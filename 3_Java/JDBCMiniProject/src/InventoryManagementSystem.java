import java.sql.*;
import java.util.Scanner;
import static java.sql.DriverManager.getConnection;

public class InventoryManagementSystem{
    //    Basic config declarations
    static final String url = System.getenv("DB_URL");
    static final String username = System.getenv("DB_USERNAME");
    static final String password = System.getenv("DB_PASSWORD");

    private static void createTable(Connection con) throws SQLException{
        String[] createTables = {"""
            create table IF NOT EXISTS suppliers (
                supplier_id int auto_increment primary key,
                supplier_name varchar(100) not null CHECK (supplier_name <> ''),
                phone varchar(10)
            );""",

                """
            create table if not exists products(
                product_id int auto_increment primary key,
                supplier_id int,
                product_name varchar(100) not null CHECK (product_name <> ''),
                price Decimal(10,2) not null CHECK (price > 0),
                stock int not null CHECK (stock >= 0),

                FOREIGN KEY(supplier_id) REFERENCES suppliers(supplier_id) ON DELETE SET NULL
            );""",

                """
            create table if not exists sales(
                sale_id int auto_increment primary key,
                product_id int not null,
                quantity_sold int not null CHECK(quantity_sold > 0),
                total_amount Decimal(10,2) not null CHECK(total_amount > 0.0),
                sale_date DATE not null,

                FOREIGN KEY (product_id) REFERENCES products(product_id)
            );"""
        };

        try (Statement state = con.createStatement()){
            for (String createQuery : createTables) {
                state.execute(createQuery);
            }
            System.out.println("Table Created Successfully!");
//        } catch(SQLException e) {
//            System.out.println("Error creating tables : " + e.getMessage());
        }
    }

    //    Defining my methods
    private static void addProducts(Scanner scan, Connection con) {
//        Prepare string
        String addProdQuery = "insert into products (supplier_id, product_name, price, stock) values (?, ?, ?, ?)";
        try (PreparedStatement prepAddProd = con.prepareStatement(addProdQuery)) {
            char choice = 0;
            int batchCount = 0;

//        Take deets as a loop because multiple products at once, then only batch processing makes sense
            do {
                int supplierID;
                String prodName;
                double price;
                int stock;
                boolean validProduct;

                do {
                    validProduct = true;

                    System.out.print("Enter Supplier ID : ");
                    supplierID = scan.nextInt();

                    scan.nextLine(); // Clear buffer again because prev is int next is String
                    System.out.print("Enter Product Name : ");
                    prodName = scan.nextLine();

                    if (prodName.trim().isEmpty()) {
                        System.out.println("Validation Error: Product name cannot be empty.");
                        validProduct = false;
                    }

                    System.out.print("Enter Price : ");
                    price = scan.nextDouble();

                    if (price <= 0) {
                        System.out.println("Validation Error: Price must be greater than 0.");
                        validProduct = false;
                    }

                    System.out.print("Enter Initial Stock : ");
                    stock = scan.nextInt();

                    if (stock < 0) {
                        System.out.println("Validation Error: Stock cannot be negative.");
                        validProduct = false;
                    }

                    if (!validProduct) {
                        System.out.println("Please enter the product details again.");
                    }

                } while (!validProduct);

                prepAddProd.setInt(1, supplierID);
                prepAddProd.setString(2, prodName);
                prepAddProd.setDouble(3, price);
                prepAddProd.setInt(4, stock);
                prepAddProd.addBatch();

                batchCount++;
                System.out.print("Add another product to this batch? (y/n): ");
                choice = scan.next().toLowerCase().charAt(0);

            } while (choice == 'y');

//            prepAddProd.addBatch(); //bundle up as a batch so that it can be rolled back if error
            if (batchCount > 0) {
                int[] rowsAffected = prepAddProd.executeBatch();
                con.commit();
                System.out.println("Batch execution successful! Total products added: " + rowsAffected.length);
            } else {
                System.out.println("No products added.");
            }

        } catch (Exception ex) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Failed to add products: " + ex.getMessage());
        }
    }

    private static void updateStock(Scanner scan, Connection con) {
        String restockQ = "update products set stock = stock + ? where product_id = ?";

        try (PreparedStatement prepUpdateStock = con.prepareStatement(restockQ)) {
            char choice = 0;
            int batchCount = 0;

            do {
                int prodId;
                int qtyToAdd;
                int rowsUpdated;
                boolean validQuantity;

                System.out.print("Enter Product ID to Restock : ");
                prodId = scan.nextInt();

                do {
                    System.out.print("Enter Quantity to Add : ");
                    qtyToAdd = scan.nextInt();

                    validQuantity = qtyToAdd > 0;

                    if (!validQuantity) {
                        System.out.println("Validation Error: Restock quantity must be positive.");
                    }
                } while (!validQuantity);

                prepUpdateStock.setInt(1, qtyToAdd);
                prepUpdateStock.setInt(2, prodId);
                prepUpdateStock.addBatch();
                batchCount++;

                System.out.print("Restock another product in this batch? (y/n): ");
                choice = scan.next().toLowerCase().charAt(0);

            } while (choice == 'y');

            if (batchCount > 0) {
                int[] rowsAffected = prepUpdateStock.executeBatch();

                for (int rowsUpdatedCount : rowsAffected) {
                    if (rowsUpdatedCount == 0 ||
                            rowsUpdatedCount == Statement.EXECUTE_FAILED) {
                        throw new SQLException(
                                "Restock failed. Check whether all Product IDs exist."
                        );
                    }
                }

                con.commit();
                System.out.println("Batch stock update successful!");
            }
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Batch restock failed : " + e.getMessage());
        }
    }

    private static void recordSale(Scanner scan, Connection con) {
        System.out.print("Enter Product ID being sold : ");
        int prodId = scan.nextInt();
        System.out.print("Enter Quantity Sold : ");
        int qtySold = scan.nextInt();

        if (qtySold <= 0) {
            System.out.println("Validation Error: Quantity sold must be greater than zero.");
            return;
        }

        String checkStockQ = "select price, stock from products where product_id = ?";
        String updateStockQ = "update products set stock = stock - ? where product_id = ? AND stock >= ?";
        String insertSaleQ = "insert into sales (product_id, quantity_sold, total_amount, sale_date) values (?, ?, ?, CURDATE())";

        try {
            double unitPrice = 0.0;
            int currentStock = 0;

//            First check product availability and price
            try (PreparedStatement prepRecordSaleCheck = con.prepareStatement(checkStockQ)) {
                prepRecordSaleCheck.setInt(1, prodId);

                try (ResultSet rs = prepRecordSaleCheck.executeQuery()) {
                    if (rs.next()) {
                        unitPrice = rs.getDouble("price");
                        currentStock = rs.getInt("stock");
                    } else {
                        System.out.println("Product ID not found.");
                        return;
                    }
                }
            }

            if (currentStock < qtySold) {
                System.out.println("Transaction Failed: Insufficient stock available! Current stock: " + currentStock);
                return;
            }

            double totalAmount = unitPrice * qtySold;

//            Then update stock
            int rowsUpdated;

            try (PreparedStatement prepRecordSaleUpdate = con.prepareStatement(updateStockQ)) {
                prepRecordSaleUpdate.setInt(1, qtySold);
                prepRecordSaleUpdate.setInt(2, prodId);
                prepRecordSaleUpdate.setInt(3, qtySold);
                rowsUpdated = prepRecordSaleUpdate.executeUpdate();
            }

            if (rowsUpdated != 1) {
                throw new SQLException("Failed to update product inventory stock.");
            }

//            finally record the sale entry
            int rowsInserted;

            try (PreparedStatement prepRecordSaleInsert = con.prepareStatement(insertSaleQ)) {
                prepRecordSaleInsert.setInt(1, prodId);
                prepRecordSaleInsert.setInt(2, qtySold);
                prepRecordSaleInsert.setDouble(3, totalAmount);
                rowsInserted = prepRecordSaleInsert.executeUpdate();
            }

            if (rowsInserted == 1) {
                con.commit();
                System.out.println("Sale recorded successfully! Total Amount: INR " + totalAmount);
            } else {
                throw new SQLException("Failed to log sale record.");
            }

        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Sale transaction rolled back due to error : " + e.getMessage());
        }
    }

    private static void generateReports(Connection con) {
        String reportQ = """
            select
                count(*) AS total_products,
                sum(stock) AS total_units_in_stock,
                sum(price * stock) AS total_inventory_valuation
            from products;
            """;

        String salesReportQuery = """
            select
                count(sale_id) AS total_transactions,
                sum(quantity_sold) AS total_units_sold,
                sum(total_amount) AS total_revenue
            from sales;
            """;

        try (Statement stmtGenerateReport = con.createStatement()) {
            System.out.println("\n================ INVENTORY REPORT ================");

            try (ResultSet rs = stmtGenerateReport.executeQuery(reportQ)) {
                if (rs.next()) {
                    System.out.println("--- Summary of Stock ---");
                    System.out.println("Total Unique Products : " + rs.getInt("total_products"));
                    System.out.println("Total Units in Stock  : " + rs.getInt("total_units_in_stock"));
                    System.out.println("Inventory Valuation   : INR " + rs.getDouble("total_inventory_valuation"));
                }
            }

            System.out.println("\n--- Sales Performance ---");

            try (ResultSet rsSales = stmtGenerateReport.executeQuery(salesReportQuery)) {
                if (rsSales.next()) {
                    System.out.println("Total Sales Transactions : " + rsSales.getInt("total_transactions"));
                    System.out.println("Total Units Sold         : " + rsSales.getInt("total_units_sold"));
                    System.out.println("Total Revenue Generated  : INR " + rsSales.getDouble("total_revenue"));
                }
            }

            System.out.println("==================================================");

        } catch (SQLException e) {
            System.out.println("Report generation error : " + e.getMessage());
        }
    }

    private static void addSupplier(Scanner scan, Connection con) {
//        add suppliers
        scan.nextLine();

        System.out.print("Enter Supplier Name : ");
        String supplierName = scan.nextLine();
        System.out.print("Enter Phone Number : ");
        String phone = scan.nextLine();

        String addSupplierQ = "insert into suppliers (supplier_name, phone) values (?, ?)";

        try (PreparedStatement prepAddSupplier = con.prepareStatement(addSupplierQ)) {
            prepAddSupplier.setString(1, supplierName);
            prepAddSupplier.setString(2, phone);

            int rowsAffected = prepAddSupplier.executeUpdate();

            if (rowsAffected > 0) {
                con.commit();
                System.out.println("Supplier Registered Successfully! Rows Affected : " + rowsAffected);
            }

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Failed to register supplier : " + e.getMessage());
        }
    }

    static void main() throws SQLException {
//        Open connections and other Objects to be used later
//        Connection con = null;
//        PreparedStatement insert = null;
//        PreparedStatement update = null;
//        PreparedStatement select = null;
//        System.out.println(url + " " + username + " " +  password);
        try {
//            First get connection from DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
            return;
        }

        try (Connection con = getConnection(url, username, password)) {
            con.setAutoCommit(false);
//            for controlled commit-rollback practice
            createTable(con);

//            Set up the multi-optional menu system
            int choice;
            Scanner scan = new Scanner(System.in);

            do {
                System.out.println("===== Welcome To Inventory Manager =====");
                System.out.print("1. Add Supplier\n2. Add Product\n3. Update Stock\n4. Record Sale\n5. Generate Reports\n6.Exit\nWhat would you like to do? ===> ");

                while (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    scan.next();
                }

                choice = scan.nextInt();

//            Switch based on user selection
                switch (choice) {
                    case 1 -> addSupplier(scan, con);
                    case 2 -> addProducts(scan, con);
                    case 3 -> updateStock(scan, con);
                    case 4 -> recordSale(scan, con);
                    case 5 -> generateReports(con);
                    case 6 -> System.out.println("EXIT");
                    default -> System.out.println("Please enter a valid choice.");
                }

            } while (choice != 6);

            scan.close();
// End here
        } catch (SQLException e) {
            System.out.println("Database Connection Error : " + e.getMessage());
        }
    }
}
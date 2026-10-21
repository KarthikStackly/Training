import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class LibraryManagementSystem {
    //    Basic config declarations
    static final String url = System.getenv("DB_URL");
    static final String username = System.getenv("DB_USERNAME");
    static final String password = System.getenv("DB_PASSWORD");

    //    Create tables
    private static void createTable(Connection con) throws SQLException {
        String[] createTables = {"""
            create table IF NOT EXISTS books(
            book_id int primary key auto_increment,
            title varchar(150) not null,
            author varchar(100) not null,
            quantity int not null CHECK (quantity >= 0)
            );""",

                """
            create table if not exists members(
            member_id int auto_increment primary key,
            name varchar(100) not null,
            email varchar(100) unique not null,
            phone varchar(10)
            );""",

                """
            create table if not exists book_issues(
            issue_id int auto_increment primary key,
            book_id int not null,
            member_id int not null,
            issue_date DATE not null,
            return_date DATE,
            status varchar(20) DEFAULT 'ISSUED',
            fine_amount DECIMAL(10,2) DEFAULT 0.00,
            
            FOREIGN KEY (book_id) REFERENCES books(book_id),
            FOREIGN KEY (member_id) REFERENCES members(member_id)
            );"""
        };

        try (Statement state = con.createStatement()) {
//            con = getConnection(url, username, password);
//            Statement state = con.createStatement();

            for (String createQuery : createTables) {
                state.execute(createQuery);
            }

            con.commit();
            System.out.println("Table Created Successfully!");
        }
    }

    private static void registerMember(Scanner scan, Connection con) {
        scan.nextLine(); // consume newline
        System.out.print("Enter Member Name : ");
        String name = scan.nextLine();
        System.out.print("Enter Member Email : ");
        String email = scan.nextLine();
        System.out.print("Enter Phone Number (10 digits) : ");
        String phone = scan.nextLine();

        String insertMemberQ = "insert into members (name, email, phone) values (?, ?, ?)";

        try (PreparedStatement pMems = con.prepareStatement(insertMemberQ)) {
            pMems.setString(1, name);
            pMems.setString(2, email);
            pMems.setString(3, phone);

            int rowsAffected = pMems.executeUpdate();
            if (rowsAffected > 0) {
                con.commit();
                System.out.println("Member Registered Successfully! Rows Affected : " + rowsAffected);
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Failed to register member (Email might already exist) : " + e.getMessage());
        }
    }

    //    Defining my methods
    private static void addBook(Scanner scan, Connection con) {
        scan.nextLine();
        System.out.print("Enter Book Title : ");
        String title = scan.nextLine();
        System.out.print("Enter Author Name : ");
        String author = scan.nextLine();
        System.out.print("Enter QUanitty : ");
        int quantity = scan.nextInt();

        String addQ = "insert into books (title, author, quantity) values (?,?,?)"; //JDBC takes care of the semicolon at the end of the query... we don't need to add in code.

        try (PreparedStatement prepareInsert = con.prepareStatement(addQ)) {
            prepareInsert.setString(1, title);
            prepareInsert.setString(2, author);
            prepareInsert.setInt(3, quantity);
// executeUpdate returns the no of rows affected. we save it
            int rowsAffected = prepareInsert.executeUpdate();
            if (rowsAffected > 0) {
                con.commit();
                System.out.println("Added Books! Rows Affected : " + rowsAffected);
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Failed to add book : " + e.getMessage());
        }
//        Book adding logic
//        System.out.println("Book Added");
    }

    private static void searchBook(Scanner scan, Connection con) {
//        Book searching logic
//        System.out.println("Book Searched");
        scan.nextLine(); //Consuiming new Line
        System.out.print("Enter Title/Author to search : ");
//        String selectRes = scan.nextLine();
        String selectRes = "%" + scan.nextLine() + "%"; //String concat, prepping for setString

        String selectQ = "Select * from books where title LIKE ? OR author LIKE ?";

        try (PreparedStatement prepareSelect = con.prepareStatement(selectQ)) {
            prepareSelect.setString(1, selectRes);
            prepareSelect.setString(2, selectRes);
            try (ResultSet rs = prepareSelect.executeQuery()) {
                System.out.println("\n ======= Search Results =======");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.printf("ID : %d | Title : %s | Author : %s | Quantity : %d%n", rs.getInt("book_id"), rs.getString("title"), rs.getString("author"), rs.getInt("quantity"));
                }
                if (!found) {
                    System.out.println("No matches found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Search Error : " + e.getMessage());
        }
    }

    private static void issueBook(Scanner scan, Connection con) {
//        Book Issuing logic (update db, minus from record)
//        System.out.println("Book Issued");
        System.out.print("Enter Book ID to issue : ");
        int bookID = scan.nextInt();
        System.out.print("Enter Member ID to issue : ");
        int memberID = scan.nextInt();

//        First check availability
        String checkBookAvail = "Select quantity from books where book_id = ?";
        try {
            int avail = 0;
            try (PreparedStatement checkBook = con.prepareStatement(checkBookAvail)) {
                checkBook.setInt(1, bookID);
                try (ResultSet rs = checkBook.executeQuery()) {
                    if (rs.next()) {
                        avail = rs.getInt("quantity");
                    } else {
                        System.out.println("Book with the ID not found");
                        return;
                    }
                }
            }
            if (avail <= 0) {
                System.out.println("Transaction failed : Book is unavailable");
                return;
            }

//Execute stock update in books table
            int rowsUpdated;
            String updateStockQ = "update books set quantity = quantity - 1 where book_id = ? AND quantity > 0";
            try (PreparedStatement updateQ = con.prepareStatement(updateStockQ)) {
                updateQ.setInt(1, bookID);
                rowsUpdated = updateQ.executeUpdate();
            }

            if (rowsUpdated != 1) {
                throw new SQLException("Could not update book stock...");
            }

// Update record in book_issues table
            String insertIssueQ = "insert into book_issues (book_id, member_id, issue_date) values (?, ?, CURDATE())";
            int rowsInserted;
            try (PreparedStatement insertQ = con.prepareStatement(insertIssueQ)) {
                insertQ.setInt(1, bookID);
                insertQ.setInt(2, memberID);
                rowsInserted = insertQ.executeUpdate();
            }
            if (rowsInserted > 0) {
                con.commit();
                System.out.println("Books issued Successfully!. Rows affected : " + rowsInserted);
            } else {
                throw new SQLException("Failed to create book issue record");
            }
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println("Transaction Rolled Back due to some error : " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void returnBook(Scanner scan, Connection con) {
//        Book returning logic (update db, plus to record)
//        System.out.println("Book Returned");
        System.out.print("Enter ISssue ID to return : ");
        int issueID = scan.nextInt();

        String getDetailsQ = "select book_id, issue_date from book_issues where issue_id = ? AND status = ?";

        try {
            int bookID = -1;
            Date issueDate = null;

            try (PreparedStatement selectQ = con.prepareStatement(getDetailsQ)) {
                selectQ.setInt(1, issueID);
                selectQ.setString(2, "ISSUED");
                try (ResultSet rs = selectQ.executeQuery()) {
                    if (rs.next()) {
                        bookID = rs.getInt("book_id");
                        issueDate = rs.getDate("issue_date");
                    } else {
                        System.out.println("Invalid Issue ID / book already returned");
                        return;
                    }
                }
            }

            // fine calc logic
            long daysBorrowed = java.time.temporal.ChronoUnit.DAYS.between(issueDate.toLocalDate(), java.time.LocalDate.now());
            double fine = daysBorrowed > 14 ? (daysBorrowed - 14) * 10.0 : 0.0;

//            Update in stock
            String updateIssueQ = "update book_issues SET status = ?, return_date = CURDATE(), fine_amount = ? where issue_id = ? AND status = ?";
            try(PreparedStatement prepateUpdateIssue = con.prepareStatement(updateIssueQ)) {
                prepateUpdateIssue.setString(1, "RETURNED");
                prepateUpdateIssue.setDouble(2, fine);
                prepateUpdateIssue.setInt(3, issueID);
                prepateUpdateIssue.setString(4, "ISSUED");

                int stockIssues = prepateUpdateIssue.executeUpdate();
                if (stockIssues != 1) {
                    throw new SQLException("Failed to update book issue record.");
                }
        }
//            books restock
            String updateStockQ = "update books SET quantity = quantity + 1 WHERE book_id = ?";
            try(PreparedStatement prepareUpdateStock = con.prepareStatement(updateStockQ)) {
                prepareUpdateStock.setInt(1, bookID);

                int stockRows = prepareUpdateStock.executeUpdate();
                if (stockRows != 1) {
                    throw new SQLException("Failed to update book stock.");
                }
            }

            con.commit();
            System.out.println("Book Returned! Fine calculates to be : " + fine);
    } catch(SQLException e) {
            try {
                con.rollback();
                System.out.println("Transaction rolled back : " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
}

    private static void calculateFine(Scanner scan, Connection con) {
//        Fine calc logic
//        System.out.println("Fine Calculated");
        System.out.print("Enter Member ID to check fines/dues : ");
        int memberID = scan.nextInt();

        String selectQ = """
                select BI.issue_id, B.title, BI.issue_date, DATEDIFF(CURDATE(), BI.issue_date) AS Total_Days_Borrowed
                from book_issues BI JOIN books B ON BI.book_id = B.book_id
                where BI.member_id = ? AND BI.status = ?;
                """;

        try(PreparedStatement prepareFees = con.prepareStatement(selectQ)) {
            prepareFees.setInt(1, memberID);
            prepareFees.setString(2, "ISSUED");
            try(ResultSet rs = prepareFees.executeQuery()) {
                System.out.println("=== Books Borrowed & Dues as on date ===");
                boolean found = false;
                while(rs.next()) {
                    found = true;
                    int days = rs.getInt("Total_Days_Borrowed");
                    double estimateFine = days > 14 ? (days - 14) * 10.0 : 0.00;
                    System.out.printf("Issue ID : %d | Title : %s | Days Borrowed : %d | Fine : INR %.2f%n", rs.getInt("issue_id"), rs.getString("title"), days, estimateFine);
                }
                if(!found) {
                    System.out.println("No Active books");
                }
            }
        } catch (SQLException e) {
            System.out.println("Fine calculation error : " + e.getMessage());
        }
    }

    static void main() {
//        Open connections and other Objects to be used later
//        Connection con = null;
//        PreparedStatement insert = null;
//        PreparedStatement update = null;
//        PreparedStatement select = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found!");
            return;
        }

//            First get connection from DriverManager
        try (Connection con = getConnection(url, username, password)) {
//            con = getConnection(url, username, password);
//            for controlled commit-rollback practice
            con.setAutoCommit(false);

            createTable(con);

//            Set up the multi-optional menu system
            int choice;
            Scanner scan = new Scanner(System.in);
            do {
                System.out.println("===== WELCOME TO JAVA LIBRARY =====");
                System.out.print("1. Register Members\n2. Add Books\n3. Search Books\n4. Issue Book\n5. Return Book\n6.Fine Calculation\nWhat would you like to do? ===> ");

                while (!scan.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    scan.next();
                }

                choice = scan.nextInt();
//            Switch based on user selection
                switch (choice) {
                    case 1 -> registerMember(scan, con);
                    case 2 -> addBook(scan, con);
                    case 3 -> searchBook(scan, con);
                    case 4 -> issueBook(scan, con);
                    case 5 -> returnBook(scan, con);
                    case 6 -> calculateFine(scan, con);
                    case 7 -> System.out.println("EXIT");
                    default -> System.out.println("Please enter a valid choice.");
                }
            } while (choice != 7);
            scan.close();
// End main code here

        } catch(SQLException e) {
            System.out.println("Some Error : " + e.getMessage());
        }
//        finally {
//            con.close();
//        }
    }
}

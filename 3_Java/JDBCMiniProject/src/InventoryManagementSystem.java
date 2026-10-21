import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class InventoryManagementSystem{
    //    Basic config declarations
    static final String url = System.getenv("URL");
    static final String username = System.getenv("USERNAME");
    static final String password = System.getenv("PASSWORD");

    private static void createTable(Connection con) throws SQLException{
        String[] createTables = {"""
            create table IF NOT EXISTS books ()
            book_id int primary key auto_increment,
            title varchar(150) not null,
            author varchar(100) not null,
            quantity int not null CHECK (quantity >= 0)
            );""",

            """
            create table if not exists members(
            member_id int auto_increment primary key,
            name varchar(100) int not null,
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

        try {
//           con = getConnection();
           Statement state = con.createStatement();

           for (String createQuery : createTables) {
               state.execute(createQuery);
           }
            System.out.println("Table Created Successfully!");

        } catch(SQLException e) {
            System.out.println("Error creating tables : " + e.getMessage());
        }
    }

    //    Defining my methods
    private static void addBook(Scanner scan) {
//        Book adding logic
        System.out.println("Book Added");
    }
    private static void searchBook(Scanner scan) {
//        Book searching logic
        System.out.println("Book Searched");
    }
    private static void issueBook(Scanner scan) {
//        Book Issuing logic (update db, minus from record)
        System.out.println("Book Issued");
    }
    private static void returnBook(Scanner scan) {
//        Book returning logic (update db, plus to record)
        System.out.println("Book Returned");
    }
    private static void calculateFine(Scanner scan) {
//        Fine calc logic
        System.out.println("Fine Calculated");
    }

    static void main() throws SQLException {
//        Open connections and other Objects to be used later
        Connection con = null;
        PreparedStatement insert = null;
        PreparedStatement update = null;
        PreparedStatement select = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            First get connection from DriverManager
            con = getConnection(url, username, password);
//            for controlled commit-rollback practice
            con.setAutoCommit(false);

//            Set up the multi-optional menu system
            int choice;
            Scanner scan = new Scanner(System.in);
            do {
                System.out.println("===== WELCOME TO JAVA LIBRARY =====");
                System.out.print("1. Add Books\n2. Search Books\n3. Issue Book\n4. Return Book\n5.Fine Calculation\nWhat would you like to do? ===> ");
                choice = scan.nextInt();
//            Switch based on user selection
                switch (choice) {
                    case 1 -> addBook(scan);
                    case 2 -> searchBook(scan);
                    case 3 -> issueBook(scan);
                    case 4 -> returnBook(scan);
                    case 5 -> calculateFine(scan);
                    case 6 -> System.out.println("EXIT");
                    default -> System.out.println("Please enter a valid choice.");
                }
            } while (choice != 6);
            scan.close();
// End here

        } catch(Exception e) {
            try{
                if(con != null) {
                    con.rollback();
                    System.out.println("Rollback initiated...");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            con.close();

        }
    }
}

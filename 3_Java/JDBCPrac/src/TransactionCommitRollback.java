import java.sql.*;

public class TransactionCommitRollback {
    static final String url = "jdbc:mysql://localhost:3306/jdbcPrac";
    static final String user = "root";
    static final String pass = "KingOfHell@1826";

    static void main() throws SQLException {
        Connection con = null;
        PreparedStatement insert = null;
        PreparedStatement update = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            First get connection from DriverManager
            con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false); // is true by default. We are making it manual so we can use later.

//            Begin preparing the string with
            String insertQuery = "insert into students(name, email) values(?, ?)";
//            Call the prepareStatement method with the prepared string as params. Not required if not prepared statement (no variables)
            insert = con.prepareStatement(insertQuery);

            insert.setString(1, "kamala");
            insert.setString(2, "kamala@gmail.com");
            insert.addBatch(); //add to the batch. why here? idk. yet...

            insert.setString(1, "karnataka");
            insert.setString(2, "kerala@gmail.com");
//since I didn't add the above to to executeBatch, the next one most likely replaced it..
            insert.setString(1, "kubera");
            insert.setString(2, "kubera@gmail.com");
            insert.addBatch();

            insert.executeBatch();

            String updateQuery = "update students set email = ? where studentID = ?";
            update = con.prepareStatement(updateQuery);

            update.setString(1, "jamal@gmail.com");
            update.setInt(2, 4); //introducing error/bug. There isn't an id 4 here so update won't affect any rows.. Right?
            update.addBatch();

            update.setString(1, "karnataka@gmail.com");
            update.setInt(2, 2);
            update.addBatch();

            update.executeBatch();

//            Done with executions>? okay next
            con.commit(); //manually setting true.
            System.out.println("Transaction committed successfully!");

        } catch(Exception ex) {
            try{
                if(con != null) {
                    con.rollback();
                    System.out.println("Transaction rollback...");
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            update.close();
            insert.close();
            con.close();
        }
    }
}

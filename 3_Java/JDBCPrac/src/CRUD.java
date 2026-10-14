import java.sql.*;

public class CRUD {
    static final String url = "jdbc:mysql://localhost:3306/jdbcPrac";
    static final String user = "root";
    static final String pass = "KingOfHell@1826";



    static void main() {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            String insert = "insert into Emp_table(empname, email) values (?,?)";
            PreparedStatement psinsert = con.prepareStatement(insert);

            psinsert.setString(1, "kamala;");
            psinsert.setString(2, "kamala@gmail.com;");

            psinsert.executeUpdate();
            System.out.println("Records inserted!!!");

//            ----------UPDATE-----------
            String update = "update Emp_table set empname = ?, email = ? where empid = ?"; //since I have 3 variables (?) to account for
            PreparedStatement psupdate = con.prepareStatement(update);

//I need to have 3 updates below. Similar to printf formatting
            psupdate.setString(1, "kala"); //first question mark
            psupdate.setString(2, "kala@gmail.com"); //second question mark
            psupdate.setInt(3, 1); //third question mark

            psupdate.executeUpdate();
            System.out.println("Updated Successfully!");

//            con.commit();
//            System.out.println("Transaction committed");


//            --------DELETE
            String notOne = "select empid from Emp_table where empid != ?";
            PreparedStatement getID = con.prepareStatement(notOne);

            getID.setInt(1, 1);
//            ResultSet rs1 = getID.executeQuery(notOne);
            ResultSet rs1 = getID.executeQuery(); //I'm getting a pool / stream of response
            System.out.println("Asking for id...");

            String delete = "delete from Emp_table where empid = ?";
            PreparedStatement psdeleteNotOne = con.prepareStatement(delete);

            while(rs1.next()) {
                int delEmpid = rs1.getInt("empid"); //I know they're all ints
                psdeleteNotOne.setInt(1, delEmpid);
//                psdeleteNotOne.setInt(1, rs1.getInt("empid"));
//                psdeleteNotOne.executeUpdate();
                int rowDeleted = psdeleteNotOne.executeUpdate();

                System.out.println("Deleted ID " + delEmpid + ": " + rowDeleted + " row(s)");
            }
//            PreparedStatement psdelete2 = con.prepareStatement(delete);
//            psdelete2.setInt(1, 2);
//            PreparedStatement psdelete3 = con.prepareStatement(delete);
//            psdelete3.setInt(1, 3);
//            PreparedStatement psdelete4 = con.prepareStatement(delete);
//            psdelete4.setInt(1, 4);
//            PreparedStatement psdelete5 = con.prepareStatement(delete);
//            psdelete5.setInt(1, 5);
//            PreparedStatement psdelete6 = con.prepareStatement(delete);
//            psdelete6.setInt(1, 6);
//            PreparedStatement psdelete7 = con.prepareStatement(delete);
//            psdelete7.setInt(1, 7);
//            PreparedStatement psdelete8 = con.prepareStatement(delete);
//            psdelete8.setInt(1, 8);
//            I Anticipated an extra row addition and added the next id supposed to be generated, scheduled it for deletion. It DID Execute!!!
//            psdelete2.executeUpdate();
//            psdelete3.executeUpdate();
//            psdelete4.executeUpdate();
//            psdelete5.executeUpdate();
//            psdelete6.executeUpdate();
//            psdelete7.executeUpdate();
//            psdelete8.executeUpdate();
            System.out.println("Records Deleted Successfully!!");

            String select = "select * from Emp_table";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()){
                System.out.printf("%d %s %s%n", rs.getInt("empid"), rs.getString("empname"), rs.getString("email"));
            }

        } catch (Exception ex) {
                ex.printStackTrace();
        }
    }
}

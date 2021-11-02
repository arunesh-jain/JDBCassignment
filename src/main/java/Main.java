import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/dbms_assignment","javaintern","Password@123");

            Statement statement = connect.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("select * from dbms_assignment.productRecords");
            System.out.println("\t\tPID\t\t\t   PNAME   \t\t\t\t\tPRICE\n");
            while (resultSet.next()) {
                int pid = resultSet.getInt("pid");
                String name = resultSet.getString("pname");
                int price = resultSet.getInt("price");
                System.out.println("\t\t" + pid + " \t\t" + name + "\t\t\t\t" + price +"\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
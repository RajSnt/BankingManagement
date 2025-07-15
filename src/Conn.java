import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        //First step is to connect the Java ide with your sql
        //We use try and catch block for exception handling over here as mysql is a outside entity, so runtime errors are caught here
        //STEP 1: REGISTER THE DRIVERS
        try {
            //(Not needed anymore as the jar file for connector does this automatically) Class.forName(com.mysql.cj.jdbc.Driver);
            //STEP 2: CREATE CONNECTION
            c= DriverManager.getConnection("jdbc:mysql:///BankManagementSystem", "root", "Raj2712@1.");
            s = c.createStatement();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

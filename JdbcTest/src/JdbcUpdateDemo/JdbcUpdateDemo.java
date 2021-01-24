package JdbcUpdateDemo;

import java.sql.*;

public class JdbcUpdateDemo {
    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String user = "student_for_practice";
        String pass = "student";

        try {
            // Get a connection to db
            myConn = DriverManager.getConnection(dbUrl, user, pass);

            // Create a statement
            myStmt = myConn.createStatement();

            // UPDATE the employee
            int rowsAffected = myStmt.executeUpdate(
                    "update employees " +
                            "set email='john.doe@gmail.com' " +
                            "where last_name='Doe' and first_name='John'");


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}

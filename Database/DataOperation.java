/*
Author: Zhekun Qi
Description: open and link the database, now serve as the main
 */
 package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class DataOperation {
    Connection conn;
    public  void connectDatabase() throws  Exception{
        StoredProcedure a1 = new StoredProcedure();
        //URL for the database
        String url = "jdbc:mysql://localhost:3306/team32";
        //username
        String username = "root";
        //password
        //if there are errors like  'Access denied for user 'root'@'localhost',  please refer to
        // https://stackoverflow.com/questions/41645309/mysql-error-access-denied-for-user-rootlocalhost
        String password = "root";

        //1.load driver
        // you must down load connector/j first and add it to the library
        //down load address
        // https://dev.mysql.com/downloads/connector/j/
        //add to libraries refers to
        // https://stackoverflow.com/questions/30651830/use-jdbc-mysql-connector-in-intellij-idea
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.access the link with database
        conn = DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws Exception {
        StoredProcedure a1 = new StoredProcedure();
        //URL for the database
        String url = "jdbc:mysql://localhost:3306/team32";
        //username
        String username = "root";
        //password
        //if there are errors like  'Access denied for user 'root'@'localhost',  please refer to
        // https://stackoverflow.com/questions/41645309/mysql-error-access-denied-for-user-rootlocalhost
        String password = "root";

        //1.load driver
        // you must down load connector/j first and add it to the library
        //down load address
        // https://dev.mysql.com/downloads/connector/j/
        //add to libraries refers to
        // https://stackoverflow.com/questions/30651830/use-jdbc-mysql-connector-in-intellij-idea
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.access the link with database
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.the sql statement sending to database
        Statement st = conn.createStatement();

        String sql = "select username from employee";
        //4.send the sql to database
        ResultSet rs = st.executeQuery(sql);

        //5.print the result
        while (rs.next()) {
            System.out.println("id = " + rs.getObject("username"));
        }

        //test 15
        //a1.admin_create_theater(conn, "tryinserttheater", "4400 Theater Company", "abc","dcb", "ga", "30309", 10, "manager3");
        //try the stored procedure 16a, the easiest one
/*        ResultSet rs1 = a1.admin_view_comDetail_emp(conn, "4400 Theater Company");
        while (rs1.next()) {
            System.out.println("firstname and lastname : " + rs1.getObject("firstname") + "  " + rs1.getObject("lastname"));

        }
        //try the stored procedure 16b, the easiest one
        ResultSet rs2 = a1.admin_view_comDetail_th(conn, "4400 Theater Company");
        while (rs2.next()) {
            System.out.println("Theater_Name, Theater_Managerusername, Theater_city,state,Theater_capacity  : " + rs2.getObject("thName") + "  " + rs2.getObject("username")+ "  " + rs2.getObject("thCity")+ "  " + rs2.getObject("thState")+ "  " + rs2.getObject("thCapacity"));
        }*/

        //test 18

        //6.close the link and release the source
        //rs1.close();
        rs.close();
        st.close();
        conn.close();
    }
}

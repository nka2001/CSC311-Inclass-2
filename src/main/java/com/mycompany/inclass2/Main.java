//this inclass shows how to access a database using java, the database comes from Access
package com.mycompany.inclass2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        String databaseURL = "";
        Connection c = null;

        try {//this try-catch block establishes a connection to the database
            databaseURL = "jdbc:ucanaccess://.//Database1.accdb";
            c = DriverManager.getConnection(databaseURL);
            System.out.println("CONNECTED");

        } catch (SQLException ex) {
            System.out.println("Error");
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }

        try {//this try-catch block will pull data from a database
            String tableName = "Persons";
            Statement stmt = c.createStatement();
            ResultSet result = stmt.executeQuery("select * from " + tableName); // this is the database query

            while (result.next()) {
                int id = result.getInt("ID");//name of column 1
                String first = result.getString("FirstName");//name of column 2
                String last = result.getString("LastName");//name of column 3
                int age = result.getInt("Age");//name of column 4
                System.out.printf("%d %s %s %d\n", id, first, last, age);//prints out the data
            }
        } catch (SQLException except) {
            except.printStackTrace();
        }
        
        String FirstName = "Mike";//data to add
        String LastName = "Andrle";
        int Age = 65;
        
        
        try {//this try-catch block will add a row to the database
            String sql = "INSERT INTO Database1 (FirstName, LastName, Age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setInt(3, Age);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Row inserted");
            }
        } catch (SQLException e) {
            System.out.println("error adding");
            
        }

    }

}

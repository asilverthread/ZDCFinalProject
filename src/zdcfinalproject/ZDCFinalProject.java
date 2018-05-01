/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zdcfinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Interact
 */
public class ZDCFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        String connStr = "jdbc:derby://localhost:1527/dbCoffeeStoreData";
        
        //<editor-fold defaultstate="collapsed" desc="EXPAND THIS FOR SQL STRINGS">
        //CREATE STATEMENTS
        String dbCustomerTableCreate = "CREATE TABLE CUSTOMER (CUST_ID INT NOT NULL, FIRST_NAME CHAR(25) NOT NULL, LAST_NAME CHAR(25) NOT NULL, STREET CHAR(50), CITY CHAR(50), STATE CHAR(2), ZIP CHAR(10), PHONE CHAR(18), EMAIL CHAR(60), CREDIT_LIMIT FLOAT)";
        String dbCoffeeTableCreate = "CREATE TABLE COFFEE (COFFEE_ID INT NOT NULL, NAME CHAR(30), DESCRIPTION CHAR(200), PRICE FLOAT, STOCK_QUANTITY INT)";
        String dbOrderTableCreate = "CREATE TABLE ORDERS (ORDER_ID INT, FK_CUST_ID INT, FK_COFFEE_ID INT, NUM_ORDERED FLOAT, TOTAL FLOAT)";
       
        
        //INSERT STATEMENTS
        String[] dbCustomerTableInsert = {
            "INSERT INTO CUSTOMER VALUES (1,'Doctor','Buttwinds','120 Real Street','Windy Knob','OK','12345','(123)456-7890','when@who.why',12.01)",
            "INSERT INTO CUSTOMER VALUES (2,'Hector','McDiddlySwank','121 Reel Street','Swanksville','KY','67890','(123)456-7891','what@when.who',13.02)",
            "INSERT INTO CUSTOMER VALUES (3,'Donovan','Dundernuggets','122 Roll Street','Stinksboro','MD','74108','(123)456-7892','which@what.how',14.03)",
            "INSERT INTO CUSTOMER VALUES (4,'Jennifer','Doorknob','123 Fake Street','Door Knob','NY','85209','(123)456-7893','why@who.how',19.98)",
            "INSERT INTO CUSTOMER VALUES (5,'Walter','Pancakelicker','124 Rail Street','Pancake Heights','NC','96307','(123)456-7894','ilickpancakesallday@pancake.com',20.18)"
        };
        String[] dbCoffeeTableInsert = {
            "INSERT INTO COFFEE VALUES (1,'Wiggly Roast','Gets you extra wiggly in the morning',12.99,17)",
            "INSERT INTO COFFEE VALUES (2,'Upset Roast','Gets you really fired up in the morning',2.99,55)",
            "INSERT INTO COFFEE VALUES (3,'Inquisitive Roast','Gets you questioning life in the morning',9.99,23)",
            "INSERT INTO COFFEE VALUES (4,'Destructive Roast','Melts through your cup and into the carpet in the morning',.99,67)",
            "INSERT INTO COFFEE VALUES (5,'Empty Roast','Gets you an empty cup in the morning',.09,137)",
            "INSERT INTO COFFEE VALUES (6,'Chads Chai','Gets you an eyepatch and a good time in the morning',2.79,16)"
        };
        String[] dbOrderTableInsert = {
            "INSERT INTO ORDERS VALUES (1,1,1,2,25.98)",
            "INSERT INTO ORDERS VALUES (2,5,6,1,2.79)",
            "INSERT INTO ORDERS VALUES (3,4,3,1,9.99)",
            "INSERT INTO ORDERS VALUES (4,3,4,2,1.98)",
            "INSERT INTO ORDERS VALUES (5,4,2,1,2.99)",
            "INSERT INTO ORDERS VALUES (6,2,1,1,12.99)",
            "INSERT INTO ORDERS VALUES (7,1,5,3,.27)",
            "INSERT INTO ORDERS VALUES (8,3,2,1,2.99)",
            "INSERT INTO ORDERS VALUES (9,5,1,1,12.99)",
            "INSERT INTO ORDERS VALUES (10,2,6,2,5.58)"            
        };
        //DROP STATEMENTS
        String dbCustomerTableDrop = "DROP TABLE CUSTOMER";
        String dbCoffeeTableDrop = "DROP TABLE COFFEE";
        String dbOrderTableDrop = "DROP TABLE ORDERS";
        //</editor-fold>
        
        Connection coffeeConnection = DriverManager.getConnection(connStr);
        
        //CREATE THE TABLES
        coffeeConnection.prepareStatement(dbCustomerTableCreate).execute();
        coffeeConnection.prepareStatement(dbCoffeeTableCreate).execute();
        coffeeConnection.prepareStatement(dbOrderTableCreate).execute();
        
        //POPULATE THE TABLES
        for(String s : dbCustomerTableInsert){
            coffeeConnection.prepareStatement(s).execute();
        }
        for(String s : dbCoffeeTableInsert){
            coffeeConnection.prepareStatement(s).execute();
        }
        for(String s : dbOrderTableInsert){
            coffeeConnection.prepareStatement(s).execute();
        }
        
        //DELETE THE TABLES
        coffeeConnection.prepareStatement(dbCustomerTableDrop).execute();
        coffeeConnection.prepareStatement(dbCoffeeTableDrop).execute();
        coffeeConnection.prepareStatement(dbOrderTableDrop).execute();
        
        }
    
}

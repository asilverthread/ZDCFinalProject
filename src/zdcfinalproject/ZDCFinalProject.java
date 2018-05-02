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
                
        Connection coffeeConnection = DriverManager.getConnection(connStr);     
                
        frmMain f = new frmMain(coffeeConnection);
        f.setVisible(true);
        }    
}

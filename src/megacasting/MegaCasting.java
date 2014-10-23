/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author theodore
 */
public class MegaCasting {

    /**
     * @param args the command line arguments
     */
    
    public static void loadDriver() {
        try {
            
            //Chargement du driver MSSQL Server
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        loadDriver();
        String url = "jdbc:jtds:sqlserver://localhost:1433/MegaCastingCL";
        Connection cnx = null;
        
        try {
            
            cnx = DriverManager.getConnection(url, "sa", "not24get");
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException ex){
                    
                }
            }
        }
    }
    
}

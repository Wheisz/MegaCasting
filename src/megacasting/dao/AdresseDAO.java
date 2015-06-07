/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import megacasting.entite.Adresse;
import megacasting.entite.Societe;

/**
 *
 * @author theodore
 */
public class AdresseDAO {
    
    public static void creer (Connection cnx, Adresse a) throws Exception  {
        
        Adresse aTemp = trouver(cnx, a.getNumero(), a.getRue(), a.getCodePostal(), a.getVille());
        if (aTemp != null) {
            throw new Exception("Cette adresse existe déjà !");
        }
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("INSERT INTO Adresse "
                    + "(Numero, Rue, CodePostal, Ville) "
                    + "VALUES (" + a.getNumero() + ", '" + a.getRue() + "', '"
                    + a.getCodePostal() + "', '" + a.getVille() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM Adresse");
            
            if(rs.next()) {
                a.setId(rs.getLong(1));
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex){
                    
                }
            }
        }   
    }
    
    public static void modifier (Connection cnx, Adresse a) throws Exception {
        
        Adresse aTemp = trouver(cnx, a.getNumero(), a.getRue(), a.getCodePostal(), a.getVille());
        if (aTemp != null && aTemp.getId() != a.getId()) {
            throw new Exception("Cette adresse existe déjà !");
        }
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE Adresse "
                    + "SET Numero = " + a.getNumero()
                    + ", Rue = '" + a.getRue()
                    + "', CodePostal = '" + a.getCodePostal()
                    + "', Ville = '" + a.getVille()
                    + "' WHERE Id = " + a.getId()
            );

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex){
                    
                }
            }
        }   
    }
    
    public static void supprimer (Connection cnx, Adresse a) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM Adresse "
                    + "WHERE Id = " + a.getId()
            );
         
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex){
                    
                }
            }
        }   
    }
    
    public static ArrayList<Adresse> lister (Connection cnx) {
        
        ArrayList<Adresse> adresses = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Numero, Rue, CodePostal, Ville FROM Adresse");
            
            while(rs.next()) {
                Adresse a = new Adresse(rs.getLong(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                adresses.add(a);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex){
                    
                }
            }
        }         
        return adresses;
    }
    
    public static Adresse trouver (Connection cnx, long idAdresse) {
        Adresse a = null;
        
        Statement stmt = null;
        long id = 0;
        int numero = 0;
        String rue = null;
        String cp = null;
        String ville = null;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Numero, Rue, CodePostal, Ville FROM Adresse "
                    + "WHERE Id = " + idAdresse);
            
            if(rs.next()) {
                id = rs.getLong(1);
                numero = rs.getInt(2);
                rue = rs.getString(3);
                cp = rs.getString(4);
                ville = rs.getString(5);                
                
                a = new Adresse(id, numero, rue, cp, ville);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex){
                    
                }
            }
        }      
        
        return a;
    }
    
    public static Adresse trouver (Connection cnx, int numero, String rue, String cp, String ville) {
        Adresse a = null;
        
        Statement stmt = null;
        long id = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Numero, Rue, CodePostal, Ville "
                    + "FROM Adresse "
                    + "WHERE Numero = " + numero + " AND Rue = '" + rue 
                    + "' AND CodePostal = '"  + cp 
                    + "' AND Ville = '" + ville + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);                
                a = new Adresse(id, numero, rue, cp, ville);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex){
                    
                }
            }
        }       
        return a;
    }
}

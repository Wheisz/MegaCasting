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
import megacasting.entite.Domaine;

/**
 *
 * @author theodore
 */
public class DomaineDAO {
    
    public static void creer (Connection cnx, Domaine d) throws Exception  {
        
        Domaine dTemp = trouver(cnx, d.getLibelle());
        if (dTemp != null) {
            throw new Exception("Ce domaine existe déjà !");
        }
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("INSERT INTO Domaine (Libelle) "
                    + "VALUES (" + d.getLibelle() + ")");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM Domaine");
            
            if(rs.next()) {
                d.setId(rs.getLong(1));
                System.out.println("Domaine ajouté ! (Id = " + d.getId() + ")");
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
    
    public static void modifier (Connection cnx, Domaine d) throws Exception {
        
        Domaine dTemp = trouver(cnx, d.getLibelle());
        if (dTemp != null) {
            throw new Exception("Ce domaine existe déjà !");
        }
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE Domaine "
                    + "SET Libelle = " + d.getLibelle()
            );

            System.out.println("Domaine modifié !");
            
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
    
    public static void supprimer (Connection cnx, Domaine d) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM Domaine "
                    + "WHERE Id = " + d.getId()
            );

            System.out.println("Domaine supprimé !");            
            
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
    
    public static ArrayList<Domaine> lister (Connection cnx) {
        
        ArrayList<Domaine> domaines = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle FROM Domaine");
            
            while(rs.next()) {
                Domaine d = new Domaine(rs.getLong(1), rs.getString(2));
                domaines.add(d);
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
        return domaines;
    }
    
    public static Domaine trouver (Connection cnx, long id) {
        Domaine d = null;
        
        Statement stmt = null;
        String libelle = null;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle FROM Domaine "
                    + "WHERE Id = " + id);
            
            if(rs.next()) {
                libelle = rs.getString(2);                
                d = new Domaine(id, libelle);
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
        return d;
    }
    
    public static Domaine trouver (Connection cnx, String libelle) {
        Domaine d = null;
        
        Statement stmt = null;
        long id = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle "
                    + "FROM Domaine "
                    + "WHERE Libelle = '" + libelle + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);                
                d = new Domaine(id, libelle);
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
        return d;
    }
}

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
import megacasting.entite.TypeContrat;

/**
 *
 * @author theodore
 */
public class TypeContratDAO {
    
    public static void creer (Connection cnx, TypeContrat tc) throws Exception  {
        
        TypeContrat tcTemp = trouver(cnx, tc.getLibelle());
        if (tcTemp != null) {
            throw new Exception("Ce type de contrat existe déjà !");
        }
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("INSERT INTO TypeContrat (Libelle) "
                    + "VALUES (" + tc.getLibelle() + ")");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM TypeContrat");
            
            if(rs.next()) {
                tc.setId(rs.getLong(1));
                System.out.println("TypeContrat ajouté ! (Id = " + tc.getId() + ")");
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
    
    public static void modifier (Connection cnx, TypeContrat tc) throws Exception {
        
        TypeContrat tcTemp = trouver(cnx, tc.getLibelle());
        if (tcTemp != null) {
            throw new Exception("Ce type de contrat existe déjà !");
        }
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE TypeContrat "
                    + "SET Libelle = " + tc.getLibelle()
            );

            System.out.println("TypeContrat modifié !");
            
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
    
    public static void supprimer (Connection cnx, TypeContrat tc) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM TypeContrat "
                    + "WHERE Id = " + tc.getId()
            );

            System.out.println("Type de contrat supprimé !");            
            
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
    
    public static ArrayList<TypeContrat> lister (Connection cnx) {
        
        ArrayList<TypeContrat> typeContrats = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle FROM TypeContrat");
            
            while(rs.next()) {
                TypeContrat tc = new TypeContrat(rs.getLong(1), rs.getString(2));
                typeContrats.add(tc);
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
        return typeContrats;
    }
    
    public static TypeContrat trouver (Connection cnx, long id) {
        TypeContrat tc = null;
        
        Statement stmt = null;
        String libelle = null;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle FROM TypeContrat "
                    + "WHERE Id = " + id);
            
            if(rs.next()) {
                libelle = rs.getString(2);                
                tc = new TypeContrat(id, libelle);
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
        return tc;
    }
    
    public static TypeContrat trouver (Connection cnx, String libelle) {
        TypeContrat tc = null;
        
        Statement stmt = null;
        long id = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle "
                    + "FROM TypeContrat "
                    + "WHERE Libelle = '" + libelle + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);                
                tc = new TypeContrat(id, libelle);
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
        return tc;
    }
}

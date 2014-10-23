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
import megacasting.entite.Societe;

/**
 *
 * @author theodore
 */
public class SocieteDAO {
    
    public static void creer (Connection cnx, Societe s) throws Exception {
        
        Societe pTemp = trouver(cnx, p.getNom(), p.getPrenom());
        if (pTemp != null) {
            throw new Exception("Cette societe existe déjà !");
        }
        
        AdresseDAO.creer(cnx, p.getAdresse());
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            // Il manque la vérification que la personne n'existe pas
            stmt.executeUpdate("INSERT INTO Personne "
                    + "(Nom, Prenom, Age, IdAdresse) "
                    + "VALUES ('" + p.getNom() + "', '" + p.getPrenom() + "', "
                    + p.getAge() + ", '" + p.getAdresse().getId() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM Personne");
            
            if(rs.next()) {
                p.setId(rs.getLong(1));
                System.out.println("Personne ajoutée ! (Id = " + p.getId() + ")");
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
    
    public static void modifier (Connection cnx, Societe s) throws Exception {
        
        Personne pTemp = trouver(cnx, p.getNom(), p.getPrenom());
        if (pTemp != null) {
            throw new Exception("Cette personne existe déjà !");
        }
        
        AdresseDAO.modifier(cnx, p.getAdresse());
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE Personne "
                    + "SET Nom = '" + p.getNom()
                    + "', Prenom = '" + p.getPrenom()
                    + "', Age = " + p.getAge()
                    + ", IdAdresse = '" + p.getAdresse().getId()
                    + "' WHERE Id = " + p.getId()
            );

            System.out.println("Personne modifiée !");
            
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
    
    public static void supprimer (Connection cnx, Societe s) {
        
        AdresseDAO.supprimer(cnx, s.getAdresse());
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM Societe "
                    + "WHERE Id = " + s.getId()
            );

            System.out.println("Personne supprimée !");            
            
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
    
    public static ArrayList<Personne> lister (Connection cnx) {
        
        ArrayList<Personne> personnes = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Nom, Prenom, Age, IdAdresse FROM Personne");
            
            while(rs.next()) {
                Adresse a = AdresseDAO.trouver(cnx, rs.getLong(5));
                Personne p = new Personne(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), a);
                personnes.add(p);
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
        return personnes;
    }
    
    public static Personne trouver (Connection cnx, long id) {
        Personne p = null;
        
        Statement stmt = null;
        String nom = null;
        String prenom = null;
        int age = 0;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Nom, Prenom, Age, IdAdresse FROM Personne "
                    + "WHERE Id = " + id);
            
            if(rs.next()) {
                nom = rs.getString(2);
                prenom = rs.getString(3);
                age = rs.getInt(4);
                idAdresse = rs.getLong(5);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                p = new Personne(id, nom, prenom, age, a);
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
        return p;
    }
    
    public static Personne trouver (Connection cnx, String nom, String prenom) {
        Personne p = null;
        
        Statement stmt = null;
        long id = 0;
        int age = 0;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Nom, Prenom, Age, IdAdresse FROM Personne "
                    + "WHERE Nom = '" + nom + "' AND Prenom = '" + prenom + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                age = rs.getInt(4);
                idAdresse = rs.getLong(5);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                p = new Personne(id, nom, prenom, age, a);
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
        return p;
    }
}

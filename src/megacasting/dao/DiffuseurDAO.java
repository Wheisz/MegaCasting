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
import megacasting.entite.Diffuseur;

/**
 *
 * @author kevin
 */
public class DiffuseurDAO {
    
    public static void creer (Connection cnx, Diffuseur diffuseur) throws Exception {
        
        Diffuseur dTemp = trouver(cnx, diffuseur.getRaisonSociale());
        if (dTemp != null) {
            throw new Exception("La societe " + diffuseur.getRaisonSociale() + " existe déjà !");
        }
        
        SocieteDAO.creer(cnx, diffuseur);
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();

            stmt.executeUpdate("INSERT INTO Diffuseur "
                    + "(Id) "
                    + "VALUES (" + diffuseur.getId() 
                    + ")");
            
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
    
    public static void modifier (Connection cnx, Diffuseur diffuseur) throws Exception {
        
        Diffuseur dTemp = trouver(cnx, diffuseur.getRaisonSociale());
        if (dTemp != null && dTemp.getId() != diffuseur.getId()) {
            throw new Exception("Le diffuseur " + diffuseur.getRaisonSociale() + " existe déjà !");
        }
        
        SocieteDAO.modifier(cnx, diffuseur);
        
    }
    
    public static void supprimer (Connection cnx, Diffuseur diffuseur) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();

            stmt.executeUpdate("DELETE FROM Diffuseur "
                    + "WHERE Id = " + diffuseur.getId()
            );
            
            SocieteDAO.supprimer(cnx, diffuseur);
       
            
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
    
    public static ArrayList<Diffuseur> lister (Connection cnx) {
        
        ArrayList<Diffuseur> diffuseurs = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT d.Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id, Discr "
                    + "FROM Diffuseur d "
                    + "INNER JOIN Societe s ON d.Id = s.Id ");
            
            while(rs.next()) {
                Adresse a = AdresseDAO.trouver(cnx, rs.getLong(6));
                Diffuseur diffuseur = new Diffuseur(rs.getLong(1),rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5), a, rs.getString(7));
                diffuseurs.add(diffuseur);
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
        return diffuseurs;
    }
    
    public static Diffuseur trouver (Connection cnx, long id) {
        Diffuseur diffuseur = null;
        
        Statement stmt = null;
        long numeroSiret = 0;
        String raisonSociale = null;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        String discr = null;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT d.Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id, Discr "
                    + "FROM Diffuseur d "
                    + "INNER JOIN Societe s ON d.Id = s.Id "
                    + "WHERE d.Id = " + id);       
            
            if(rs.next()) {
                numeroSiret = rs.getLong(2);
                raisonSociale = rs.getString(3);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse adr = AdresseDAO.trouver(cnx, idAdresse);
                discr = rs.getString(7);
                diffuseur = new Diffuseur(id, numeroSiret, raisonSociale, email, telephone, adr, discr);
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
        return diffuseur;
    }
    
    public static Diffuseur trouver (Connection cnx, String raisonSociale) {
        Diffuseur diffuseur = null;
        
        Statement stmt = null;
        long id = 0;
        long numeroSiret = 0;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        String discr = null;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT d.Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id, Discr "
                    + "FROM Diffuseur d "
                    + "INNER JOIN Societe s ON d.Id = s.Id "
                    + "WHERE RaisonSociale = '" + raisonSociale + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                numeroSiret = rs.getLong(2);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                discr = rs.getString(7);
                diffuseur = new Diffuseur(id, numeroSiret, raisonSociale, email, telephone, a, discr);
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
        return diffuseur;
    }
    
}

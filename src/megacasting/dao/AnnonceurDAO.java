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
import megacasting.entite.Annonceur;

/**
 *
 * @author theodore
 */
public class AnnonceurDAO {
    
    public static void creer (Connection cnx, Annonceur annonceur) throws Exception {
        
        Annonceur aTemp = trouver(cnx, annonceur.getRaisonSociale());
        if (aTemp != null) {
            throw new Exception("La societe " + annonceur.getRaisonSociale() + " existe déjà !");
        }
        
        SocieteDAO.creer(cnx, annonceur);
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();

            stmt.executeUpdate("SET IDENTITY_INSERT Annonceur ON "
                    + "INSERT INTO Annonceur "
                    + "(Id) "
                    + "VALUES (" + annonceur.getId()
                    + ") SET IDENTITY_INSERT Annonceur OFF");

            System.out.println("La société " + annonceur.getRaisonSociale() + "(Id = " + annonceur.getId() + ") a été ajoutée !");   
            
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
    
    public static void modifier (Connection cnx, Annonceur annonceur) throws Exception {
        
        Annonceur aTemp = trouver(cnx, annonceur.getRaisonSociale());
        if (aTemp != null && aTemp.getId() != annonceur.getId()) {
            throw new Exception("L'annonceur " + annonceur.getRaisonSociale() + " existe déjà !");
        }
        
        SocieteDAO.modifier(cnx, annonceur);
        
        System.out.println("L'annonceur " + annonceur.getRaisonSociale() + " a été modifié !");
    }
    
    public static void supprimer (Connection cnx, Annonceur annonceur) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();

            stmt.executeUpdate("DELETE FROM Annonceur "
                    + "WHERE Id = " + annonceur.getId()
            );

            System.out.println("L'annonceur " + annonceur.getRaisonSociale() + " a été supprimé !");            
            
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
    
    public static ArrayList<Annonceur> lister (Connection cnx) {
        
        ArrayList<Annonceur> annonceurs = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT a.Id, RaisonSociale, Email, Telephone, IdAdresse "
                    + "FROM Annonceur a "
                    + "INNER JOIN Societe s ON a.Id = s.Id ");
            
            while(rs.next()) {
                Adresse a = AdresseDAO.trouver(cnx, rs.getLong(5));
                Annonceur annonceur = new Annonceur(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), a);
                annonceurs.add(annonceur);
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
        return annonceurs;
    }
    
    public static Annonceur trouver (Connection cnx, long id) {
        Annonceur annonceur = null;
        
        Statement stmt = null;
        String raisonSociale = null;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT a.Id, RaisonSociale, Email, Telephone, IdAdresse "
                    + "FROM Annonceur a "
                    + "INNER JOIN Societe s ON a.Id = s.Id "
                    + "WHERE a.Id = " + id);       
            
            if(rs.next()) {
                raisonSociale = rs.getString(2);
                email = rs.getString(3);
                telephone = rs.getString(4);
                idAdresse = rs.getLong(5);                
                Adresse adr = AdresseDAO.trouver(cnx, idAdresse);
                annonceur = new Annonceur(id, raisonSociale, email, telephone, adr);
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
        return annonceur;
    }
    
    public static Annonceur trouver (Connection cnx, String raisonSociale) {
        Annonceur annonceur = null;
        
        Statement stmt = null;
        long id = 0;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT a.Id, RaisonSociale, Email, Telephone, IdAdresse "
                    + "FROM Annonceur a "
                    + "INNER JOIN Societe s ON a.Id = s.Id "
                    + "WHERE RaisonSociale = '" + raisonSociale + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                email = rs.getString(3);
                telephone = rs.getString(4);
                idAdresse = rs.getLong(5);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                annonceur = new Annonceur(id, raisonSociale, email, telephone, a);
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
        return annonceur;
    }
}

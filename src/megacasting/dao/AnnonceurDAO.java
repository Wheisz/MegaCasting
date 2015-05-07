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
import megacasting.entite.Offre;

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

            stmt.executeUpdate(
                    "INSERT INTO Annonceur "
                    + "(Id) "
                    + "VALUES (" + annonceur.getId()
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
    
    public static void modifier (Connection cnx, Annonceur annonceur) throws Exception {
        
        Annonceur aTemp = trouver(cnx, annonceur.getRaisonSociale());
        if (aTemp != null && aTemp.getId() != annonceur.getId()) {
            throw new Exception("L'annonceur " + annonceur.getRaisonSociale() + " existe déjà !");
        }

        SocieteDAO.modifier(cnx, annonceur);
        
    }
    
    public static void supprimer (Connection cnx, Annonceur annonceur) {
        
        Statement stmt = null;
        try {
            ArrayList<Offre> offres = OffreDAO.lister(cnx, annonceur);
            for(Offre o : offres){
                OffreDAO.supprimer(cnx, o);
            }
            
            stmt = cnx.createStatement();

            stmt.executeUpdate("DELETE FROM Annonceur "
                    + "WHERE Id = " + annonceur.getId()
            );

            SocieteDAO.supprimer(cnx, annonceur);
                       
            
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
            
            ResultSet rs = stmt.executeQuery("SELECT a.Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id "
                    + "FROM Annonceur a "
                    + "INNER JOIN Societe s ON a.Id = s.Id ");
            
            while(rs.next()) {
                Adresse a = AdresseDAO.trouver(cnx, rs.getLong(6));
                Annonceur annonceur = new Annonceur(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5), a);
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
        long numeroSiret = 0;
        String raisonSociale = null;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT a.Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id "
                    + "FROM Annonceur a "
                    + "INNER JOIN Societe s ON a.Id = s.Id "
                    + "WHERE a.Id = " + id);       
            
            if(rs.next()) {
                numeroSiret = rs.getLong(2);
                raisonSociale = rs.getString(3);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse adr = AdresseDAO.trouver(cnx, idAdresse);
                annonceur = new Annonceur(id, numeroSiret, raisonSociale, email, telephone, adr);
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
        long numeroSiret = 0;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT a.Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id "
                    + "FROM Annonceur a "
                    + "INNER JOIN Societe s ON a.Id = s.Id "
                    + "WHERE RaisonSociale = '" + raisonSociale + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                numeroSiret = rs.getLong(2);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                annonceur = new Annonceur(id, numeroSiret, raisonSociale, email, telephone, a);
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

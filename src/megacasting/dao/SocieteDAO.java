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
import megacasting.entite.Societe;

/**
 *
 * @author theodore
 */
public class SocieteDAO {
    
    public static void creer (Connection cnx, Societe s) throws Exception {
        
        
        AdresseDAO.creer(cnx, s.getAdresse());
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("INSERT INTO Societe "
                    + "(NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id) "
                    + "VALUES ("+ s.getNumeroSiret() +", '" + s.getRaisonSociale() + "', '" + s.getEmail() + "', '"
                    + s.getTelephone() + "', '" + s.getAdresse().getId() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM Societe");
            
            if(rs.next()) {
                s.setId(rs.getLong(1));
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
        
        Societe sTemp = trouver(cnx, s.getRaisonSociale());
        if (sTemp != null && sTemp.getId() != s.getId()) {
            throw new Exception("La societe " + s.getRaisonSociale() + " existe déjà !");
        }

        AdresseDAO.modifier(cnx, s.getAdresse());
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE Societe "
                    + "SET NumeroSiret = " + s.getNumeroSiret()
                    + ", RaisonSociale = '" + s.getRaisonSociale()
                    + "', Email = '" + s.getEmail()
                    + "', Telephone = '" + s.getTelephone()
                    + "', Adresse_id = " + s.getAdresse().getId()
                    + " WHERE Id = " + s.getId()
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
    
    public static void supprimer (Connection cnx, Societe s) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM Societe "
                    + "WHERE Id = " + s.getId()
            );
            
            AdresseDAO.supprimer(cnx, s.getAdresse());
                       
            
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
    
    public static ArrayList<Societe> lister (Connection cnx) {
        
        ArrayList<Societe> societes = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id "
                    + "FROM Societe");
            
            while(rs.next()) {
                Adresse a = AdresseDAO.trouver(cnx, rs.getLong(6));
                Societe s = new Societe(rs.getLong(1),rs.getLong(2), rs.getString(3), rs.getString(4), rs.getString(5), a);
                societes.add(s);
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
        return societes;
    }
    
    public static Societe trouver (Connection cnx, long id) {
        Societe s = null;
        
        Statement stmt = null;
        long numeroSiret = 0;
        String raisonSociale = null;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id FROM Societe "
                    + "WHERE Id = " + id);
            
            if(rs.next()) {
                numeroSiret = rs.getLong(2);
                raisonSociale = rs.getString(3);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                s = new Societe(id, numeroSiret, raisonSociale, email, telephone, a);
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
        return s;
    }
    
    public static Societe trouver (Connection cnx, String raisonSociale) {
        Societe s = null;
        
        Statement stmt = null;
        long id = 0;
        long numeroSiret = 0;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id FROM Societe "
                    + "WHERE RaisonSociale = '" + raisonSociale + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                numeroSiret = rs.getLong(2);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                s = new Societe(id, numeroSiret, raisonSociale, email, telephone, a);
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
        return s;
    }
    
    public static Societe trouverByNumSiret (Connection cnx, String numeroSiret) {
        Societe s = null;
        
        Statement stmt = null;
        long id = 0;
        long numSiret = 0;
        String raisonSociale = null;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, NumeroSiret, RaisonSociale, Email, Telephone, Adresse_id FROM Societe "
                    + "WHERE NumeroSiret = '" + numeroSiret + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                numSiret = Long.parseLong(numeroSiret);
                raisonSociale = rs.getString(3);
                email = rs.getString(4);
                telephone = rs.getString(5);
                idAdresse = rs.getLong(6);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                s = new Societe(id, numSiret, raisonSociale, email, telephone, a);
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
        return s;
    }
}

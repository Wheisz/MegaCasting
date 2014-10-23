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
        
        Societe sTemp = trouver(cnx, s.getRaisonSociale());
        if (sTemp != null) {
            throw new Exception("La societe " + s.getRaisonSociale() + " existe déjà !");
        }
        
        AdresseDAO.creer(cnx, s.getAdresse());
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("INSERT INTO Societe "
                    + "(RaisonSociale, Email, Telephone, IdAdresse) "
                    + "VALUES ('" + s.getRaisonSociale() + "', '" + s.getEmail() + "', '"
                    + s.getTelephone() + "', '" + s.getAdresse().getId() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM Societe");
            
            if(rs.next()) {
                s.setId(rs.getLong(1));
                System.out.println("La société " + s.getRaisonSociale() + "(Id = " + s.getId() + ") a été ajoutée !");
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
                    + "SET RaisonSociale = '" + s.getRaisonSociale()
                    + "', Email = '" + s.getEmail()
                    + "', Telephone = '" + s.getTelephone()
                    + "', IdAdresse = " + s.getAdresse().getId()
                    + " WHERE Id = " + s.getId()
            );

            System.out.println("La société " + s.getRaisonSociale() + " a été modifiée !");
            
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

            System.out.println("La societe " + s.getRaisonSociale() + " a été supprimée !");            
            
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
            
            ResultSet rs = stmt.executeQuery("SELECT Id, RaisonSociale, Email, Telephone, IdAdresse "
                    + "FROM Societe");
            
            while(rs.next()) {
                Adresse a = AdresseDAO.trouver(cnx, rs.getLong(5));
                Societe s = new Societe(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), a);
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
        String raisonSociale = null;
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, RaisonSociale, Email, Telephone, IdAdresse FROM Societe "
                    + "WHERE Id = " + id);
            
            if(rs.next()) {
                raisonSociale = rs.getString(2);
                email = rs.getString(3);
                telephone = rs.getString(4);
                idAdresse = rs.getLong(5);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                s = new Societe(id, raisonSociale, email, telephone, a);
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
        String email = null;
        String telephone = null;
        long idAdresse = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, RaisonSociale, Email, Telephone, IdAdresse FROM Societe "
                    + "WHERE RaisonSociale = '" + raisonSociale + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                email = rs.getString(3);
                telephone = rs.getString(4);
                idAdresse = rs.getLong(5);                
                Adresse a = AdresseDAO.trouver(cnx, idAdresse);
                s = new Societe(id, raisonSociale, email, telephone, a);
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

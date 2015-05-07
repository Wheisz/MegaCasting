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
import megacasting.entite.Metier;


/**
 *
 * @author theodore
 */
public class MetierDAO {
    
     public static void creer (Connection cnx, Metier m) {
        
        int id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            if (m.getDomaine() != null) {
                stmt.executeUpdate("INSERT INTO Metier "
                    + "(Libelle,Domaine_id) "
                    + "VALUES ('" + m.getLibelle()+ "', " + m.getDomaine().getId()+ ")");
            }
            else {
                stmt.executeUpdate("INSERT INTO Metier "
                    + "(Libelle,Domaine_id) "
                    + "VALUES ('" + m.getLibelle()+ "', " + null + ")");
            }

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id) FROM Metier");
            
            if(rs.next()) {
                m.setId(rs.getLong(1));
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
     
     public static void modifier (Connection cnx, Metier m) throws Exception {
        
        Metier mTemp = trouver(cnx, m.getLibelle());
        if (mTemp != null && mTemp.getId() != m.getId()) {
            throw new Exception("Le métier " + m.getLibelle()+ " existe déjà !");
        }
        
        DomaineDAO.modifier(cnx, m.getDomaine());
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE Metier "
                    + "SET Libelle = '" + m.getLibelle()
                    + "', Domaine_id = " + m.getDomaine().getId()
                    + " WHERE Id = " + m.getId()
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
     
     public static void supprimer (Connection cnx, Metier m) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM Metier "
                    + "WHERE Id = " + m.getId()
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
     
     public static ArrayList<Metier> lister (Connection cnx) {
        
        ArrayList<Metier> metiers = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle, Domaine_id "
                    + "FROM Metier");
            
            while(rs.next()) {
                Domaine d = DomaineDAO.trouver(cnx, rs.getLong(3));
                Metier m = new Metier(rs.getLong(1), rs.getString(2), d);
                metiers.add(m);
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
        return metiers;
    }
     
     public static ArrayList<Metier> lister (Connection cnx, Domaine domaine) {
        
        ArrayList<Metier> metiers = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = null;
            if (domaine != null) {
                rs = stmt.executeQuery("SELECT Id, Libelle, Domaine_id "
                    + "FROM Metier "
                    + "WHERE Domaine_id = " + domaine.getId());
            }
            else {
                rs = stmt.executeQuery("SELECT Id, Libelle, Domaine_id "
                    + "FROM Metier "
                    + "WHERE Domaine_id IS NULL");
            }
            
            
            while(rs.next()) {
                Domaine d = DomaineDAO.trouver(cnx, rs.getLong(3));
                Metier m = new Metier(rs.getLong(1), rs.getString(2), d);
                metiers.add(m);
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
        return metiers;
    }
     
     public static Metier trouver (Connection cnx, long id) {
        Metier m = null;
        
        Statement stmt = null;
        String libelle = null;
        long idDomaine = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle, Domaine_id FROM Metier "
                    + "WHERE Id = '" + id + "'");
            
            if(rs.next()) {
                libelle = rs.getString(2);
                idDomaine = rs.getLong(3);                
                Domaine d = DomaineDAO.trouver(cnx, idDomaine);
                m = new Metier(id, libelle,d);
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
        return m;
     }
        
     public static Metier trouver (Connection cnx, String libelle) {
        Metier m = null;
        
        Statement stmt = null;
        long id = 0;
        long idDomaine = 0;
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Libelle, Domaine_id FROM Metier "
                    + "WHERE Libelle = '" + libelle + "'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                idDomaine = rs.getLong(3);                
                Domaine d = DomaineDAO.trouver(cnx, idDomaine);
                m = new Metier(id, libelle,d);
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
        return m;
     }
     

    
}

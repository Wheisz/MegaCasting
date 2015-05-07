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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import megacasting.entite.Annonceur;
import megacasting.entite.Domaine;
import megacasting.entite.Metier;
import megacasting.entite.Offre;
import megacasting.entite.TypeContrat;

/**
 *
 * @author kevin
 */
public class OffreDAO {
    
    public static void creer (Connection cnx, Offre o) throws Exception {
        

        long id = 0;
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            Date datePublication =  new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datePublicationStr = sdf.format(datePublication);
            
            
            Date dateDebutContrat = o.getDateDebutContrat();
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            String dateDebutContratStr = sdf1.format(dateDebutContrat);
              
            String lattitude = Offre.modifCoordonnee(o.getLocalisationLattitude());
            String longitude = Offre.modifCoordonnee(o.getLocalisationLongitude());
            
            if((o.getDomaine() != null) && (o.getMetier() == null)){

            stmt.executeUpdate("INSERT INTO Offre "
                    + "(Intitule, Reference, DatePublication, DureeDiffusion, DateDebutContrat, NbPoste, LocalisationLattitude"
                    + ", LocalisationLongitude, DescriptionPoste, DescriptionProfil, Telephone, Email, Domaine_id, Metier_id"
                    + ", TypeContrat_id, Annonceur_id ) "
                    + "VALUES ('" + o.getIntitule()+ "', '" + o.getReference()+"', convert(datetime,'"
                    + datePublicationStr+"',120), " + o.getDureeDiffusion() + ", convert(datetime,'"+dateDebutContratStr+"',103), "
                    + o.getNbPoste()+", '"+ lattitude +"', '"+ longitude +"', '"
                    + o.getDescriptionPoste()+"', '"+o.getDescriptionProfil()+"', '"+o.getTelephone()+"', '"
                    + o.getEmail()+"', "+ o.getDomaine().getId() +", "+ null +", "+ o.getTypeContrat().getId() +", "
                    + o.getAnnonceur().getId() +")");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id)as Id, MAX(Domaine_id) as Domaine_id,"
                    + "                              MAX(Metier_id) as Metier_id, MAX(TypeContrat_id) as TypeContrat_id,"
                    + "                              MAX(Annonceur_id) as Annonceur_id FROM Offre");
            
            if(rs.next()) {

                o.setId(rs.getLong(1));
                o.getDomaine().setId(rs.getLong(2));
                o.getMetier().setId(rs.getLong(3));
                o.getTypeContrat().setId(rs.getLong(4));
                o.getAnnonceur().setId(rs.getLong(4));
            }  
            }
            
            if((o.getDomaine() == null) && (o.getMetier() != null)){

            stmt.executeUpdate("INSERT INTO Offre "
                    + "(Intitule, Reference, DatePublication, DureeDiffusion, DateDebutContrat, NbPoste, LocalisationLattitude"
                    + ", LocalisationLongitude, DescriptionPoste, DescriptionProfil, Telephone, Email, Domaine_id, Metier_id"
                    + ", TypeContrat_id, Annonceur_id ) "
                    + "VALUES ('" + o.getIntitule()+ "', '" + o.getReference()+"', convert(datetime,'"
                    + datePublicationStr+"',120), " + o.getDureeDiffusion() + ", convert(datetime,'"+dateDebutContratStr+"',103), "
                    + o.getNbPoste()+", '"+ lattitude +"', '"+ longitude +"', '"
                    + o.getDescriptionPoste()+"', '"+o.getDescriptionProfil()+"', '"+o.getTelephone()+"', '"
                    + o.getEmail()+"', "+ null +", "+ o.getMetier().getId() +", "+ o.getTypeContrat().getId() +", "
                    + o.getAnnonceur().getId() +")");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id)as Id, MAX(Domaine_id) as Domaine_id,"
                    + "                              MAX(Metier_id) as Metier_id, MAX(TypeContrat_id) as TypeContrat_id,"
                    + "                              MAX(Annonceur_id) as Annonceur_id FROM Offre");
            
            if(rs.next()) {
                o.setId(rs.getLong(1));
                o.getDomaine().setId(rs.getLong(2));
                o.getMetier().setId(rs.getLong(3));
                o.getTypeContrat().setId(rs.getLong(4));
                o.getAnnonceur().setId(rs.getLong(4));
            }  
            }
            
            if((o.getDomaine() != null) && (o.getMetier() != null)){

            stmt.executeUpdate("INSERT INTO Offre "
                    + "(Intitule, Reference, DatePublication, DureeDiffusion, DateDebutContrat, NbPoste, LocalisationLattitude"
                    + ", LocalisationLongitude, DescriptionPoste, DescriptionProfil, Telephone, Email, Domaine_id, Metier_id"
                    + ", TypeContrat_id, Annonceur_id ) "
                    + "VALUES ('" + o.getIntitule()+ "', '" + o.getReference()+"', convert(datetime,'"
                    + datePublicationStr+"',120), " + o.getDureeDiffusion() + ", convert(datetime,'"+dateDebutContratStr+"',103), "
                    + o.getNbPoste()+", '"+ lattitude +"', '"+ longitude +"', '"
                    + o.getDescriptionPoste()+"', '"+o.getDescriptionProfil()+"', '"+o.getTelephone()+"', '"
                    + o.getEmail()+"', "+ o.getDomaine().getId() +", "+ o.getMetier().getId() +", "+ o.getTypeContrat().getId() +", "
                    + o.getAnnonceur().getId() +")");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id)as Id, MAX(Domaine_id) as Domaine_id,"
                    + "                              MAX(Metier_id) as Metier_id, MAX(TypeContrat_id) as TypeContrat_id,"
                    + "                              MAX(Annonceur_id) as Annonceur_id FROM Offre");
            
            if(rs.next()) {
                o.setId(rs.getLong(1));
                o.getDomaine().setId(rs.getLong(2));
                o.getMetier().setId(rs.getLong(3));
                o.getTypeContrat().setId(rs.getLong(4));
                o.getAnnonceur().setId(rs.getLong(4));
            }  
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
        
    public static void modifier (Connection cnx, Offre o) throws Exception {
        
        Offre oTemp = trouver(cnx, o.getReference());
        if (oTemp != null && oTemp.getId() != o.getId()) {
            throw new Exception("L'offre " + o.getReference() + " existe déjà !");
        }
        
        Date dateDebutContrat = o.getDateDebutContrat();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        String dateDebutContratStr = sdf1.format(dateDebutContrat);
        
        String lattitude = Offre.modifCoordonnee(o.getLocalisationLattitude());
        String longitude = Offre.modifCoordonnee(o.getLocalisationLongitude());
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            if((o.getDomaine() == null) && (o.getMetier() != null)){
            stmt.executeUpdate("UPDATE Offre "
                    + "SET Intitule = '" + o.getIntitule()
                    + "', Reference = '" + o.getReference()
                    + "', DureeDiffusion = " + o.getDureeDiffusion()
                    + ", DateDebutContrat = '" + dateDebutContratStr
                    + "', NbPoste = " + o.getNbPoste()
                    + ", LocalisationLattitude = '" + lattitude
                    + "', LocalisationLongitude = '" + longitude
                    + "', DescriptionPoste = '" + o.getDescriptionPoste()
                    + "', DescriptionProfil = '" + o.getDescriptionProfil()
                    + "', Telephone = '" + o.getTelephone()
                    + "', Email = '" + o.getEmail()
                    + "', Domaine_id = " + null
                    + ", Metier_id = " + o.getMetier().getId()
                    + ", TypeContrat_id = " + o.getTypeContrat().getId()
                    + ", Annonceur_id = " + o.getAnnonceur().getId()
                    + " WHERE Id = " + o.getId()
            );
            }
            if(o.getDomaine() != null & o.getMetier() == null){
            stmt.executeUpdate("UPDATE Offre "
                    + "SET Intitule = '" + o.getIntitule()
                    + "', Reference = '" + o.getReference()
                    + "', DureeDiffusion = " + o.getDureeDiffusion()
                    + ", DateDebutContrat = '" + dateDebutContratStr
                    + "', NbPoste = " + o.getNbPoste()
                    + ", LocalisationLattitude = '" + lattitude
                    + "', LocalisationLongitude = '" + longitude
                    + "', DescriptionPoste = '" + o.getDescriptionPoste()
                    + "', DescriptionProfil = '" + o.getDescriptionProfil()
                    + "', Telephone = '" + o.getTelephone()
                    + "', Email = '" + o.getEmail()
                    + "', Domaine_id = " + o.getDomaine().getId()
                    + ", Metier_id = " + null
                    + ", TypeContrat_id = " + o.getTypeContrat().getId()
                    + ", Annonceur_id = " + o.getAnnonceur().getId()
                    + " WHERE Id = " + o.getId()
            );
            }
            if(o.getDomaine() != null & o.getMetier() != null){
            stmt.executeUpdate("UPDATE Offre "
                    + "SET Intitule = '" + o.getIntitule()
                    + "', Reference = '" + o.getReference()
                    + "', DureeDiffusion = " + o.getDureeDiffusion()
                    + ", DateDebutContrat = '" + dateDebutContratStr
                    + "', NbPoste = " + o.getNbPoste()
                    + ", LocalisationLattitude = '" + lattitude
                    + "', LocalisationLongitude = '" + longitude
                    + "', DescriptionPoste = '" + o.getDescriptionPoste()
                    + "', DescriptionProfil = '" + o.getDescriptionProfil()
                    + "', Telephone = '" + o.getTelephone()
                    + "', Email = '" + o.getEmail()
                    + "', Domaine_id = " + o.getDomaine().getId()
                    + ", Metier_id = " + o.getMetier().getId()
                    + ", TypeContrat_id = " + o.getTypeContrat().getId()
                    + ", Annonceur_id = " + o.getAnnonceur().getId()
                    + " WHERE Id = " + o.getId()
            );
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
        
    public static void supprimer (Connection cnx, Offre o) {
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("DELETE FROM Offre "
                    + "WHERE Id = " + o.getId()
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
        
    public static ArrayList<Offre> lister (Connection cnx) {
        
        ArrayList<Offre> offres = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                    + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                    + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                    + "                              , Annonceur_id   FROM Offre ");
            
            while(rs.next()) {
                Domaine d = DomaineDAO.trouver(cnx, rs.getLong(14));
                Metier m = MetierDAO.trouver(cnx, rs.getLong(15));
                TypeContrat tc = TypeContratDAO.trouver(cnx, rs.getLong(16));
                Annonceur a = AnnonceurDAO.trouver(cnx, rs.getLong(17));
                Offre o = new Offre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
                rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                rs.getString(12), rs.getString(13),d,m,tc,a);
                offres.add(o);
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
        return offres;
    }
    
    public static ArrayList<Offre> lister (Connection cnx, Domaine d) {
        
        ArrayList<Offre> offres = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT o.Id, o.Intitule, o.Reference, o.DatePublication, DureeDiffusion,DateDebutContrat"
                    + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                    + "                              , DescriptionProfil, Telephone, Email, o.Domaine_id, o.Metier_id, o.TypeContrat_id"
                    + "                              , o.Annonceur_id "
                    + "FROM Offre o "
                    + "WHERE o.Domaine_id = " + d.getId());
            
            while(rs.next()) {
                Metier m = MetierDAO.trouver(cnx, rs.getLong(15));
                TypeContrat tc = TypeContratDAO.trouver(cnx, rs.getLong(16));
                Annonceur a = AnnonceurDAO.trouver(cnx, rs.getLong(17));
                Offre o = new Offre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
                rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                rs.getString(12), rs.getString(13),d,m,tc,a);
                offres.add(o);
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
        return offres;
    }
    
    public static ArrayList<Offre> lister (Connection cnx, Metier m) {
        
        ArrayList<Offre> offres = new ArrayList();
        Statement stmt = null;
        try {
            
            if (m != null) {
                stmt = cnx.createStatement();
            
                ResultSet rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                        + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                        + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                        + "                              , Annonceur_id "   
                        + "FROM Offre o "
                        + "WHERE o.Metier_id = " + m.getId());

                while(rs.next()) {
                    Domaine d = DomaineDAO.trouver(cnx, rs.getLong(14));
                    TypeContrat tc = TypeContratDAO.trouver(cnx, rs.getLong(16));
                    Annonceur a = AnnonceurDAO.trouver(cnx, rs.getLong(17));
                    Offre o = new Offre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
                    rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                    rs.getString(12), rs.getString(13),d,m,tc,a);
                    offres.add(o);
                }
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
        return offres;
    }
    
    public static ArrayList<Offre> lister (Connection cnx, Domaine d, Metier m) {
        
        ArrayList<Offre> offres = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = null;
            if (m != null && d != null) {                
            
                rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                        + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                        + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                        + "                              , Annonceur_id "   
                        + "FROM Offre o "
                        + "WHERE o.Metier_id = " + m.getId()
                        + " AND o.Domaine_id = " + d.getId());                
            } 
            else if (m == null && d != null) {
                rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                        + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                        + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                        + "                              , Annonceur_id "   
                        + "FROM Offre o "
                        + "WHERE o.Metier_id IS NULL "
                        + "AND o.Domaine_id = " + d.getId());
            }
            else if (m != null && d == null) {
                rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                        + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                        + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                        + "                              , Annonceur_id "   
                        + "FROM Offre o "
                        + "WHERE o.Metier_id = " + m.getId()
                        + " AND o.Domaine_id IS NULL ");
            }
            while(rs.next()) {
                TypeContrat tc = TypeContratDAO.trouver(cnx, rs.getLong(16));
                Annonceur a = AnnonceurDAO.trouver(cnx, rs.getLong(17));
                Offre o = new Offre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
                rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                rs.getString(12), rs.getString(13),d,m,tc,a);
                offres.add(o);
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
        return offres;
    }
    
    public static ArrayList<Offre> lister (Connection cnx, Annonceur a) {
        
        ArrayList<Offre> offres = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                    + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                    + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                    + "                              , Annonceur_id "   
                    + "FROM Offre o "
                    + "WHERE o.Annonceur_id = " + a.getId());
            
            while(rs.next()) {
                Domaine d = DomaineDAO.trouver(cnx, rs.getLong(14));
                Metier m = MetierDAO.trouver(cnx, rs.getLong(15));
                TypeContrat tc = TypeContratDAO.trouver(cnx, rs.getLong(16));
                Offre o = new Offre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
                rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                rs.getString(12), rs.getString(13),d,m,tc,a);
                offres.add(o);
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
        return offres;
    }
    
    public static ArrayList<Offre> lister (Connection cnx, TypeContrat tc) {
        
        ArrayList<Offre> offres = new ArrayList();
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                    + "                              , NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                    + "                              , DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                    + "                              , Annonceur_id "
                    + "FROM Offre o "
                    + "WHERE o.TypeContrat_id = " + tc.getId());
            
            while(rs.next()) {
                Domaine d = DomaineDAO.trouver(cnx, rs.getLong(14));
                Metier m = MetierDAO.trouver(cnx, rs.getLong(15));
                Annonceur a = AnnonceurDAO.trouver(cnx, rs.getLong(17));
                Offre o = new Offre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5),
                rs.getDate(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                rs.getString(12), rs.getString(13),d,m,tc,a);
                offres.add(o);
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
        return offres;
    }
        
    public static Offre trouver (Connection cnx, long id) {
            
        Offre o = null;
        
        Statement stmt = null;
        
        String intitule = null;
        String reference = null;
        Date datePublication = null;
        int dureeDiffusion = 0;
        Date dateDebutContrat = null;
        int nbPoste = 0;
        String localisationLattitude = null;
        String localisationLongitude = null;
        String descriptionPoste = null;
        String descriptionProfil = null;
        String telephone = null;
        String email = null;
        long idDomaine = 0;
        long idMetier = 0;
        long idTypeContrat = 0;
        long idAnnonceur = 0;
        Domaine d = null;
        Metier m = null;
        
        
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                                                + ", NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                                                + ", DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                                                + ", Annonceur_id"
                                                + " FROM Offre"
                                                + " WHERE Id = " + id);
            
            if(rs.next()) {
                intitule = rs.getString(2);
                reference = rs.getString(3);
                datePublication = rs.getTimestamp(4);
                dureeDiffusion = rs.getInt(5);
                dateDebutContrat = rs.getDate(6);
                nbPoste = rs.getInt(7);
                localisationLattitude = rs.getString(8);
                localisationLongitude = rs.getString(9);
                descriptionPoste = rs.getString(10);
                descriptionProfil = rs.getString(11);
                telephone = rs.getString(12);
                email = rs.getString(13);
                idDomaine = rs.getLong(14);
                idMetier = rs.getLong(15);
                idTypeContrat = rs.getLong(16);
                idAnnonceur = rs.getLong(17);
                
                d = DomaineDAO.trouver(cnx, idDomaine);
                m = MetierDAO.trouver(cnx, idMetier);
                TypeContrat tc = TypeContratDAO.trouver(cnx, idTypeContrat);
                Annonceur a = AnnonceurDAO.trouver(cnx, idAnnonceur);

                o = new Offre(id,intitule,reference,datePublication,dureeDiffusion,dateDebutContrat,nbPoste,localisationLattitude,localisationLongitude,descriptionPoste,descriptionProfil,telephone,email,d,m,tc,a);
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
        return o;
    }
        
    public static Offre trouver (Connection cnx, String reference) {
        Offre o = null;
        
        Statement stmt = null;
        
        long id = 0;
        String intitule = null;
        Date datePublication = null;
        int dureeDiffusion = 0;
        Date dateDebutContrat = null;
        int nbPoste = 0;
        String localisationLattitude = null;
        String localisationLongitude = null;
        String descriptionPoste = null;
        String descriptionProfil = null;
        String telephone = null;
        String email = null;
        long idDomaine = 0;
        long idMetier = 0;
        long idTypeContrat = 0;
        long idAnnonceur = 0;
        Domaine d = null;
        Metier m = null;
        
        
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                                                + ", NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                                                + ", DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                                                + ", Annonceur_id"
                                                + " FROM Offre"
                                                + " WHERE Reference = '" + reference+"'");
            
            if(rs.next()) {
                id = rs.getLong(1);
                intitule = rs.getString(2);
                datePublication = rs.getTimestamp(4);
                dureeDiffusion = rs.getInt(5);
                dateDebutContrat = rs.getDate(6);
                nbPoste = rs.getInt(7);
                localisationLattitude = rs.getString(8);
                localisationLongitude = rs.getString(9);
                descriptionPoste = rs.getString(10);
                descriptionProfil = rs.getString(11);
                telephone = rs.getString(12);
                email = rs.getString(13);
                idDomaine = rs.getLong(14);
                idMetier = rs.getLong(15);
                idTypeContrat = rs.getLong(16);
                idAnnonceur = rs.getLong(17);
                
                d = DomaineDAO.trouver(cnx, idDomaine);
                m = MetierDAO.trouver(cnx, idMetier);
                TypeContrat tc = TypeContratDAO.trouver(cnx, idTypeContrat);
                Annonceur a = AnnonceurDAO.trouver(cnx, idAnnonceur);

                o = new Offre(id,intitule,reference,datePublication,dureeDiffusion,dateDebutContrat,nbPoste,localisationLattitude,localisationLongitude,descriptionPoste,descriptionProfil,telephone,email,d,m,tc,a);
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
        return o;
    }
    
    public static Offre trouverOld (Connection cnx) {
            
        Offre o = null;
        
        Statement stmt = null;
        
        long id = 0;
        String intitule = null;
        String reference = null;
        Date datePublication = null;
        int dureeDiffusion = 0;
        Date dateDebutContrat = null;
        int nbPoste = 0;
        String localisationLattitude = null;
        String localisationLongitude = null;
        String descriptionPoste = null;
        String descriptionProfil = null;
        String telephone = null;
        String email = null;
        long idDomaine = 0;
        long idMetier = 0;
        long idTypeContrat = 0;
        long idAnnonceur = 0;
        Domaine d = null;
        Metier m = null;
        
        
        
        try {
            stmt = cnx.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT TOP 1 "
                    + "Id, Intitule, Reference, DatePublication, DureeDiffusion,DateDebutContrat"
                                                + ", NbPoste, LocalisationLattitude, LocalisationLongitude, DescriptionPoste"
                                                + ", DescriptionProfil, Telephone, Email, Domaine_id, Metier_id, TypeContrat_id"
                                                + ", Annonceur_id"
                                                + " FROM Offre"
                                                + " ORDER BY DatePublication ASC");
            
            if(rs.next()) {
                id = rs.getLong(1);
                intitule = rs.getString(2);
                reference = rs.getString(3);
                datePublication = rs.getTimestamp(4);
                dureeDiffusion = rs.getInt(5);
                dateDebutContrat = rs.getDate(6);
                nbPoste = rs.getInt(7);
                localisationLattitude = rs.getString(8);
                localisationLongitude = rs.getString(9);
                descriptionPoste = rs.getString(10);
                descriptionProfil = rs.getString(11);
                telephone = rs.getString(12);
                email = rs.getString(13);
                idDomaine = rs.getLong(14);
                idMetier = rs.getLong(15);
                idTypeContrat = rs.getLong(16);
                idAnnonceur = rs.getLong(17);
                
                d = DomaineDAO.trouver(cnx, idDomaine);
                m = MetierDAO.trouver(cnx, idMetier);
                TypeContrat tc = TypeContratDAO.trouver(cnx, idTypeContrat);
                Annonceur a = AnnonceurDAO.trouver(cnx, idAnnonceur);

                o = new Offre(id,intitule,reference,datePublication,dureeDiffusion,dateDebutContrat,nbPoste,localisationLattitude,localisationLongitude,descriptionPoste,descriptionProfil,telephone,email,d,m,tc,a);
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
        return o;
    }
}

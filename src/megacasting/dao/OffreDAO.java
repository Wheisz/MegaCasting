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
        
        Offre oTemp = trouver(cnx, o.getReference());
        if (oTemp != null) {
            throw new Exception("L'offre " + o.getIntitule()+ " existe déjà !");
        }
        
        Metier mTemp = MetierDAO.trouver(cnx, o.getMetier().getLibelle());
        if (mTemp == null) {
        MetierDAO.creer(cnx, o.getMetier()); 

        }
        TypeContrat tcTemp = TypeContratDAO.trouver(cnx, o.getTypeContrat().getLibelle());
        if(tcTemp == null)
        {
            TypeContratDAO.creer(cnx, o.getTypeContrat());
        }
        Annonceur aTemp = AnnonceurDAO.trouver(cnx, o.getAnnonceur().getRaisonSociale());
        if(aTemp == null)
        {
            AnnonceurDAO.creer(cnx, o.getAnnonceur());
        }
    
        
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
            
            
            
            stmt.executeUpdate("INSERT INTO Offre "
                    + "(Intitule, Reference, DatePublication, DureeDiffusion, DateDebutContrat, NbPoste, LocalisationLattitude"
                    + ", LocalisationLongitude, DescriptionPoste, DescriptionProfil, Telephone, Email, IdDomaine, IdMetier"
                    + ", IdTypeContrat, IdAnnonceur ) "
                    + "VALUES ('" + o.getIntitule()+ "', '" + o.getReference()+"', convert(datetime,'"
                    +datePublicationStr+"',120), " + o.getDureeDiffusion() + ", convert(datetime,'"+dateDebutContratStr+"',103), "
                    + o.getNbPoste()+", '"+ o.getLocalisationLattitude()+"', '"+o.getLocalisationLongitude()+"', '"
                    + o.getDescriptionPoste()+"', '"+o.getDescriptionProfil()+"', '"+o.getTelephone()+"', '"
                    + o.getEmail()+"', "+ o.getDomaine().getId() +", "+ o.getMetier().getId() +", "+ o.getTypeContrat().getId() +", "
                    + o.getAnnonceur().getId() +")");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Id)as Id, MAX(IdDomaine) as IdDomaine,"
                    + "                              MAX(IdMetier) as IdMetier, MAX(IdTypeContrat) as IdTypeContrat,"
                    + "                              MAX(IdAnnonceur) as Annonceur FROM Offre");
            
            if(rs.next()) {
                o.setId(rs.getLong(1));
                o.setIdDomaine(rs.getLong(2));
                o.setIdMetier(rs.getLong(3));
                o.setIdTypeContrat(rs.getLong(4));
                o.setIdAnnonceur(rs.getLong(5));
                System.out.println("L'offre " + o.getIntitule() + "(Id = " + o.getId() + ") a été ajoutée !");
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
        
        DomaineDAO.modifier(cnx, o.getDomaine());
        MetierDAO.modifier(cnx, o.getMetier());
        TypeContratDAO.modifier(cnx, o.getTypeContrat());
        AnnonceurDAO.modifier(cnx, o.getAnnonceur());
        
        
        Statement stmt = null;
        try {
            stmt = cnx.createStatement();
            
            stmt.executeUpdate("UPDATE Offre "
                    + "SET Intitule = '" + o.getIntitule()
                    + "', Reference = '" + o.getReference()
                    + "', DureeDiffusion = " + o.getDureeDiffusion()
                    + ", DateDebutContrat = " + o.getDateDebutContrat()
                    + ", NbPoste = " + o.getNbPoste()
                    + ", LocalisationLattitude = '" + o.getLocalisationLattitude()
                    + "', LocalisationLongitude = '" + o.getLocalisationLongitude()
                    + "', DescriptionPoste = '" + o.getDescriptionPoste()
                    + "', DescriptionProfil = '" + o.getDescriptionProfil()
                    + "', Telephone = '" + o.getTelephone()
                    + "', Email = '" + o.getEmail()
                    + "', IdDomaine = " + o.getDomaine().getId()
                    + ", IdMetier = " + o.getMetier().getId()
                    + ", IdTypeContrat = " + o.getTypeContrat().getId()
                    + ", IdAnnonceur = " + o.getAnnonceur().getId()
                    + " WHERE Id = " + o.getId()
            );

            System.out.println("L'offre " + o.getReference() + " a été modifiée !");
            
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

            System.out.println("L'offre " + o.getReference()+ " a été supprimée !");            
            
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
                    + "                              , DescriptionProfil, Telephone, Email, IdDomaine, IdMetier, IdTypeContrat"
                    + "                              , IdAnnonceur   FROM Offre ");
            
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
                                                + ", DescriptionProfil, Telephone, Email, IdDomaine, IdMetier, IdTypeContrat"
                                                + ", IdAnnonceur"
                                                + " FROM Offre"
                                                + " WHERE Reference = '" + reference+"'");
            
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
                                                + ", DescriptionProfil, Telephone, Email, IdDomaine, IdMetier, IdTypeContrat"
                                                + ", IdAnnonceur"
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import megacasting.dao.AdresseDAO;
import megacasting.dao.AnnonceurDAO;
import megacasting.dao.DiffuseurDAO;
import megacasting.dao.DomaineDAO;
import megacasting.dao.MetierDAO;
import megacasting.dao.OffreDAO;
import megacasting.dao.SocieteDAO;
import megacasting.dao.TypeContratDAO;
import megacasting.entite.Adresse;
import megacasting.entite.Annonceur;
import megacasting.entite.Diffuseur;
import megacasting.entite.Domaine;
import megacasting.entite.Metier;
import megacasting.entite.Offre;
import megacasting.entite.Societe;
import megacasting.entite.TypeContrat;

/**
 *
 * @author theodore
 */
public class MegaCasting {

    /**
     * @param args the command line arguments
     */
    
    public static void loadDriver() {
        try {
            
            //Chargement du driver MSSQL Server
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        loadDriver();
        String url = "jdbc:jtds:sqlserver://localhost:1433/MegaCastingCL";
        Connection cnx = null;
        
        try {
            
            cnx = DriverManager.getConnection(url, "sa", "not24get");
           
            
            Adresse a = new Adresse(37, "rue bidule", 53000, "Laval");
            Annonceur ann = new Annonceur("McDonald", "mcdonald@gmail.com", "02.41.54.84.15", a);
            AnnonceurDAO.creer(cnx, ann);
            
            Adresse a2 = new Adresse(35, "rue test", 53000, "Laval");
            Diffuseur dif = new Diffuseur("iia", "iiagmail.com", "02.48.56.81.15", a2);
            DiffuseurDAO.creer(cnx, dif);
          
            Adresse a1 = new Adresse(27, "rue brouette", 53000, "Laval");
            Annonceur ann1 = new Annonceur("Decathlon", "decathlon@gmail.com", "02.54.87.02.33", a1);
            AnnonceurDAO.creer(cnx, ann1);
            
            System.out.println("Liste des adresses : ");
            ArrayList<Adresse> adresses = AdresseDAO.lister(cnx);
            for (Adresse adr : adresses) {
                System.out.println(adr);
            }
            
            System.out.println("Liste des annonceurs : ");
            ArrayList<Annonceur> annonceurs = AnnonceurDAO.lister(cnx);
            for (Annonceur annonceur : annonceurs) {
                System.out.println(annonceur);
            }
            
            ann.setRaisonSociale("GOULOUGOULOU");
            AnnonceurDAO.modifier(cnx, ann);
            System.out.println(AnnonceurDAO.trouver(cnx, "GOULOUGOULOU"));
            
            TypeContrat cdi = new TypeContrat("CDI");
            TypeContratDAO.creer(cnx, cdi);
            TypeContrat cdd = new TypeContrat("CDD");
            TypeContratDAO.creer(cnx, cdd);
            
            
            System.out.println("Liste des type de contrats : ");
            ArrayList<TypeContrat> typeContrats = TypeContratDAO.lister(cnx);
            for (TypeContrat tc : typeContrats) {
                System.out.println(tc);
            }
            
            System.out.println(cdi.getLibelle());
            cdi.setLibelle("HAHA");
            TypeContratDAO.modifier(cnx, cdi);
            System.out.println(TypeContratDAO.trouver(cnx, "HAHA"));
            
            Domaine musique = new Domaine("Musique");
            DomaineDAO.creer(cnx, musique);
            Domaine sport = new Domaine("Sport");
            DomaineDAO.creer(cnx, sport);
            
            System.out.println("Liste des domaines : ");
            ArrayList<Domaine> domaines = DomaineDAO.lister(cnx);
            for (Domaine domaine : domaines) {
                System.out.println(domaine);
            }
            
            musique.setLibelle("CAROTTE");
            DomaineDAO.modifier(cnx, musique);
            System.out.println(DomaineDAO.trouver(cnx, "CAROTTE"));
            
            Metier developper = new Metier("Developper",musique);
            MetierDAO.creer(cnx, developper);

            Date dateDebutContrat = Offre.changeStringInDate("22/10/2010");
            
            Offre offre1 = new Offre("recherche chanteur","Test",5,dateDebutContrat,1,"-30","50","recherche chanteur de jazz","expérimenté","0243562869","jazz.com",musique,developper,cdi,ann);
            
            OffreDAO.creer(cnx, offre1);
            
            ArrayList<Offre> offres = OffreDAO.lister(cnx);
            for(Offre o : offres)
            {
                System.out.println(o);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cnx != null) {
                try {
                    cnx.close();
                } catch (SQLException ex){
                    
                }
            }
        }
    }
    
}

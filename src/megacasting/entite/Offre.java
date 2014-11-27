/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.entite;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.jtds.jdbc.DateTime;


/**
 *
 * @author kevin
 */
public class Offre {
    
    private long id;
    private String intitule;
    private String reference;
    private Date datePublication;
    private int dureeDiffusion;
    private Date dateDebutContrat;
    private int nbPoste;
    private String localisationLattitude;
    private String localisationLongitude;
    private String descriptionPoste;
    private String descriptionProfil;
    private String telephone;
    private String email;
    private Domaine domaine;
    private Metier metier;
    private TypeContrat typeContrat;
    private Annonceur annonceur;
    private long idDomaine;
    private long idMetier;
    private long idTypeContrat;
    private long idAnnonceur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public Date getDatePublication() {
        return datePublication;
    }
    
    public int getDureeDiffusion() {
        return dureeDiffusion;
    }

    public void setDureeDiffusion(int dureeDiffusion) {
        this.dureeDiffusion = dureeDiffusion;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public int getNbPoste() {
        return nbPoste;
    }

    public void setNbPoste(int nbPoste) {
        this.nbPoste = nbPoste;
    }

    public String getLocalisationLattitude() {
        return localisationLattitude;
    }

    public void setLocalisationLattitude(String localisationLattitude) {
        this.localisationLattitude = localisationLattitude;
    }

    public String getLocalisationLongitude() {
        return localisationLongitude;
    }

    public void setLocalisationLongitude(String localisationLongitude) {
        this.localisationLongitude = localisationLongitude;
    }

    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public void setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
    }

    public String getDescriptionProfil() {
        return descriptionProfil;
    }

    public void setDescriptionProfil(String descriptionProfil) {
        this.descriptionProfil = descriptionProfil;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public Annonceur getAnnonceur() {
        return annonceur;
    }

    public void setAnnonceur(Annonceur annonceur) {
        this.annonceur = annonceur;
    }

    public long getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(long idDomaine) {
        this.idDomaine = idDomaine;
    }

    public long getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(long idMetier) {
        this.idMetier = idMetier;
    }

    public long getIdTypeContrat() {
        return idTypeContrat;
    }

    public void setIdTypeContrat(long idTypeContrat) {
        this.idTypeContrat = idTypeContrat;
    }

    public long getIdAnnonceur() {
        return idAnnonceur;
    }

    public void setIdAnnonceur(long idAnnonceur) {
        this.idAnnonceur = idAnnonceur;
    }

    @Override
    public String toString() {
        return intitule;
    }


    public static Date changeStringInDate(String str)
    {
        Date date = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
           date = sdf.parse(str);
           return date;
        } catch (ParseException ex) {
            Logger.getLogger(Offre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return date;
    }
    
    public static String modifCoordonnee(String coordonnee) 
    {
        coordonnee = coordonnee.replace("'", "''");
        return coordonnee;
    }


    public Offre(long id, String intitule, String reference,Date datePublication, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Domaine domaine, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
        this.id = id;
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication =  datePublication;
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.domaine = domaine;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
     
    public Offre(long id, String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Domaine domaine, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
        this.id = id;
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication = new Date();
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.domaine = domaine;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }

    public Offre(String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Domaine domaine, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication =  new Date();
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.domaine = domaine;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
    
    public Offre(long id, String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Domaine domaine, TypeContrat typeContrat, Annonceur annonceur) {
        this.id = id;
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication =  new Date();
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.domaine = domaine;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
    
    public Offre(String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Domaine domaine, TypeContrat typeContrat, Annonceur annonceur) {
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication =  new Date();
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.domaine = domaine;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
    
    public Offre(long id, String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
        this.id = id;
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication =  new Date();
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
    
    public Offre(String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication =  new Date();
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
}
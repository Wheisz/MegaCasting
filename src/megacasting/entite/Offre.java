/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.entite;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
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
    private boolean estValide;
    private Domaine domaine;
    private Metier metier;
    private TypeContrat typeContrat;
    private Annonceur annonceur;

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

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
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

    @Override
    public String toString() {
        return intitule;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        if (!Objects.equals(this.datePublication, other.datePublication)) {
            return false;
        }
        if (this.dureeDiffusion != other.dureeDiffusion) {
            return false;
        }
        if (!Objects.equals(this.dateDebutContrat, other.dateDebutContrat)) {
            return false;
        }
        if (this.nbPoste != other.nbPoste) {
            return false;
        }
        if (!Objects.equals(this.localisationLattitude, other.localisationLattitude)) {
            return false;
        }
        if (!Objects.equals(this.localisationLongitude, other.localisationLongitude)) {
            return false;
        }
        if (!Objects.equals(this.descriptionPoste, other.descriptionPoste)) {
            return false;
        }
        if (!Objects.equals(this.descriptionProfil, other.descriptionProfil)) {
            return false;
        }
        if (!Objects.equals(this.telephone, other.telephone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.estValide != other.estValide) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        if (!Objects.equals(this.metier, other.metier)) {
            return false;
        }
        if (!Objects.equals(this.typeContrat, other.typeContrat)) {
            return false;
        }
        if (!Objects.equals(this.annonceur, other.annonceur)) {
            return false;
        }
        return true;
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

    public Offre(long id, String intitule, String reference, Date datePublication, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, boolean estValide, Domaine domaine, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
        this.id = id;
        this.intitule = intitule;
        this.reference = reference;
        this.datePublication = datePublication;
        this.dureeDiffusion = dureeDiffusion;
        this.dateDebutContrat = dateDebutContrat;
        this.nbPoste = nbPoste;
        this.localisationLattitude = localisationLattitude;
        this.localisationLongitude = localisationLongitude;
        this.descriptionPoste = descriptionPoste;
        this.descriptionProfil = descriptionProfil;
        this.telephone = telephone;
        this.email = email;
        this.estValide = estValide;
        this.domaine = domaine;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
     
    public Offre(long id, String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, boolean estValide,Domaine domaine, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
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
        this.estValide = estValide;
        this.domaine = domaine;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }

    public Offre(String intitule, String reference, int dureeDiffusion, Date dateDebutContrat, int nbPoste, String localisationLattitude, String localisationLongitude, String descriptionPoste, String descriptionProfil, String telephone, String email, boolean estValide, Domaine domaine, Metier metier, TypeContrat typeContrat, Annonceur annonceur) {
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
        this.estValide = estValide;
        this.domaine = domaine;
        this.metier = metier;
        this.typeContrat = typeContrat;
        this.annonceur = annonceur;
    }
    
}
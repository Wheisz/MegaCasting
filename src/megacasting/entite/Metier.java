/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.entite;

/**
 *
 * @author kevin
 */
public class Metier {
    
    private long id;
    private String libelle;
    private Domaine domaine;
    private long idDomaine;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public long getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(long idDomaine) {
        this.idDomaine = idDomaine;
    }

    @Override
    public String toString() {
        return "Metier{" + "id=" + id + ", libelle=" + libelle + ", domaine=" + domaine + ", idDomaine=" + idDomaine + '}';
    }

    
    
    public Metier(long id, String libelle, Domaine domaine) {
        this.id = id;
        this.libelle = libelle;
        this.domaine = domaine;
    }

    public Metier(String libelle, Domaine domaine) {
        this.libelle = libelle;
        this.domaine = domaine;
    }
    
    
    
}

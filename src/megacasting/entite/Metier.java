/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.entite;

import java.util.Objects;

/**
 *
 * @author kevin
 */
public class Metier {
    
    private long id;
    private String libelle;
    private Domaine domaine;

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

    @Override
    public String toString() {
        return libelle;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Metier other = (Metier) obj;
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        return true;
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

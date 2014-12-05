/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.entite;

import java.util.Objects;

/**
 *
 * @author theodore
 */
public class TypeContrat {
    
    private long id;
    private String libelle;

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
        final TypeContrat other = (TypeContrat) obj;
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        return true;
    }
    

    public TypeContrat(String libelle) {
        this.libelle = libelle;
    }

    public TypeContrat(long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    
}

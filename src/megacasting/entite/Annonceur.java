/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting.entite;

/**
 *
 * @author theodore
 */
public class Annonceur extends Societe {

    public Annonceur(String raisonSociale, String email, String telephone, Adresse adresse) {
        super(raisonSociale, email, telephone, adresse);
    }

    public Annonceur(long id, String raisonSociale, String email, String telephone, Adresse adresse) {
        super(id, raisonSociale, email, telephone, adresse);
    }

    @Override
    public String toString() {
        return "Annonceur (" + id + ") : " + raisonSociale + ", " + email + ", " + telephone + ", " + adresse;
    }
    
    
}

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
public class Diffuseur extends Societe{

    public Diffuseur(long id, long numeroSiret, String raisonSociale, String email, String telephone, Adresse adresse, String discr) {
        super(id, numeroSiret, raisonSociale, email, telephone, adresse, discr);
    }

    public Diffuseur(long numeroSiret, String raisonSociale, String email, String telephone, Adresse adresse, String discr) {
        super(numeroSiret, raisonSociale, email, telephone, adresse, discr);
    }


    @Override
    public String toString() {
        return "Diffuseur (" + id + ") : " + raisonSociale + ", " + email + ", " + telephone + ", " + adresse;
    }
    
    
}

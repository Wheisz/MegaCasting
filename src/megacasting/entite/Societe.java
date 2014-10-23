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
public class Societe {
    
    protected long id;
    protected String raisonSociale;
    protected String email;
    protected String telephone;
    protected Adresse adresse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Societe(String raisonSociale, String email, String telephone, Adresse adresse) {
        this.raisonSociale = raisonSociale;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public Societe(long id, String raisonSociale, String email, String telephone, Adresse adresse) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }

}

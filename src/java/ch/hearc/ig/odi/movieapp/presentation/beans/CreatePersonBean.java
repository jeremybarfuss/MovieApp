package ch.hearc.ig.odi.movieapp.presentation.beans;

import ch.hearc.ig.odi.movieapp.services.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Bean de la page createPerson
 *
 * @author jeremy.barfuss
 * @version 1.0, 22.04.2016
 */
@Named(value = "createPersonBean")
@RequestScoped
public class CreatePersonBean {

    @Inject
    Services services;
    private long id;
    private String firstName;
    private String lastName;

    /**
     * Constructeur par d�faut du bean
     */
    public CreatePersonBean() {
    }

    /**
     * Renvoie l'identifiant de la personne
     *
     * @return Identifiant de la personne
     */
    public long getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de la personne
     *
     * @param id Nouvel identifiant de la personne
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Renvoie le pr�nom de la personne
     *
     * @return Pr�nom de la personne
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modifie le pr�nom de la personne
     *
     * @param firstName Nouveau pr�nom de la personne
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Renvoie le nom de la personne
     *
     * @return Nom de la personne
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Modifie le nom de la personne
     *
     * @param lastName Nom de la personne
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String addPerson() {
        services.addPerson(this.id, this.firstName, this.lastName);
        return "/home.xhtml";
    }

}

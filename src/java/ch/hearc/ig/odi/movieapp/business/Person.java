package ch.hearc.ig.odi.movieapp.business;

/**
 * Classe métier de personne.
 *
 * @author jeremy.barfuss
 * @version 1.0, 29.04.2016
 */
public class Person {

    private long id;
    private String firstName;
    private String lastName;

    /**
     * Constructeur de personne
     *
     * @param id Identifiant de la personne
     * @param firstName Prénom de la personne
     * @param lastName Nom de la personne
     */
    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Renvoie le prénom de la personne
     *
     * @return Prénom de la personne
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Modifie le prénom de la personne
     *
     * @param firstName Nouveau prénom de la personne
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
     * @param lastName Nouveau nom de la personne
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

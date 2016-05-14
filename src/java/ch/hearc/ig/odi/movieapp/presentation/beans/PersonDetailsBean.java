package ch.hearc.ig.odi.movieapp.presentation.beans;

import ch.hearc.ig.odi.movieapp.business.Movie;
import ch.hearc.ig.odi.movieapp.business.Person;
import ch.hearc.ig.odi.movieapp.services.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 * Bean de la page PersonDetails.
 *
 * @author jeremy.barfuss
 * @version 1.0, 21.04.2016
 */
@Named(value = "personDetailsBean")
@SessionScoped
public class PersonDetailsBean implements Serializable {

    @Inject
    Services services;
    private Person person;

    /**
     * Constructeur par défaut du bean
     */
    public PersonDetailsBean() {
    }

    /**
     * Renvoie la personne du bean
     *
     * @return Personne dont il faut afficher les détails
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Modifie la personne du bean
     *
     * @param person Nouvelle personne dont il faut afficher les détails
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Movie> getMovies() {
        return new ArrayList(this.person.getMovies().values());
    }
/**
     * Renvoie la liste des films
     *
     * @return Liste des films
     */
    public List<Movie> getAllMovies() {
        return services.getMoviesList();
    }

}

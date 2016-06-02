package ch.hearc.ig.odi.movieapp.presentation.beans;

import ch.hearc.ig.odi.movieapp.business.Movie;
import ch.hearc.ig.odi.movieapp.business.Person;
import ch.hearc.ig.odi.movieapp.exception.UniqueException;
import ch.hearc.ig.odi.movieapp.services.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 * Bean de la page PersonDetails.
 *
 * @author jeremy.barfuss
 * @version 1.0, 21.04.2016
 */
@Named(value = "personDetailsBean")
@ViewScoped
public class PersonDetailsBean implements Serializable {

    @Inject
    Services services;
    private long currentPersonID;
    private Person person;
    private Movie movieToAssign;

    /**
     * Constructeur par défaut du bean
     */
    public PersonDetailsBean() {
    }

    public long getCurrentPersonID() {
        return currentPersonID;
    }

    public void setCurrentPersonID(long currentPersonId) {
        this.currentPersonID = currentPersonId;
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

    public Movie getMovieToAssign() {
        return movieToAssign;
    }

    public void setMovieToAssign(Movie movieToAssign) {
        this.movieToAssign = movieToAssign;
    }

    public List<Movie> getUnseenMovies() {
        List<Movie> unseenMovies = new ArrayList<>();
        for (Movie movie : services.getMoviesList()) {
            if (!this.person.getMovies().containsValue(movie)) {
                unseenMovies.add(movie);
            }
        }
        return unseenMovies;
    }

    public void initPerson() {
        this.person = services.getPersonById(currentPersonID);
    }

    /**
     * Supprime un film de la personne
     *
     * @param movie film à supprimer
     */
    public void removeMovie(Movie movie) {
        try {
            person.removeMovie(movie);
        } catch (UniqueException ex) {
            Logger.getLogger(PersonDetailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void assignMovie() {
        try {
            person.addMovie(movieToAssign);
        } catch (UniqueException ex) {
            Logger.getLogger(PersonDetailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

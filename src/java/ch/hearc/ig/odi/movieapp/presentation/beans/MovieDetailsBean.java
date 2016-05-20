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
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author jeremy.barfuss
 */
@Named(value = "movieDetailsBean")
@SessionScoped
public class MovieDetailsBean implements Serializable {

    @Inject
    Services services;
    private Movie movie;
    private Person personToAssign;

    /**
     * Constructeur par défaut du bean
     */
    public MovieDetailsBean() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Person getPersonToAssign() {
        return personToAssign;
    }

    public void setPersonToAssign(Person personToAssign) {
        this.personToAssign = personToAssign;
    }

    public List<Person> getPersons() {
        return new ArrayList(this.movie.getPersons().values());
    }

    public List<Person> getUnseenPersons() {
        List<Person> unseenPersons = new ArrayList<>();
        for(Person person : services.getPeopleList()) {
            if(!this.movie.getPersons().containsValue(person)) {
                unseenPersons.add(person);
            }
        }
        return unseenPersons;
    }

    public String showMovie(Movie movie) {
        if (movie != null) {
            this.movie = movie;
            return "movieDetails";
        } else {
            this.movie = null;
            return "error";
        }
    }
    
    /**
     * Supprime une personne du film
     * @param person Personne à supprimer
     */
    public void removePerson(Person person) {
        try {
            person.removeMovie(movie);
        } catch (UniqueException ex) {
            Logger.getLogger(MovieDetailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void assignPerson() {
        try {
            personToAssign.addMovie(movie);
        } catch (UniqueException ex) {
            Logger.getLogger(MovieDetailsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

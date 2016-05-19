package ch.hearc.ig.odi.movieapp.presentation.beans;

import ch.hearc.ig.odi.movieapp.business.Movie;
import ch.hearc.ig.odi.movieapp.business.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author jeremy.barfuss
 */
@Named(value = "movieDetailsBean")
@SessionScoped
public class MovieDetailsBean implements Serializable {

    private Movie movie;

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

    public List<Person> getPersons() {
        return new ArrayList(this.movie.getPersons().values());
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
}

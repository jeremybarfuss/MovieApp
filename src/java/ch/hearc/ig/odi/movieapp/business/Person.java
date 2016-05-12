package ch.hearc.ig.odi.movieapp.business;

import java.util.HashMap;

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
    HashMap<Long, Movie> movies;

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

    /**
     * Renvoie les films vus par la personne
     *
     * @return Films vus par la personne
     */
    public HashMap<Long, Movie> getMovies() {
        return movies;
    }

    /**
     * Modifie les films vus par la personne
     *
     * @param movies Nouveaux films vu par la personne
     */
    public void setMovies(HashMap<Long, Movie> movies) {
        this.movies = movies;
    }

    /**
     * Renvoie un film par son identifiant
     *
     * @param id Identifiant du film
     * @return Film correspondant à l'identifiant
     */
    public Movie getMovieById(long id) {
        return this.movies.get(id);
    }

    /**
     * Ajoute un film
     *
     * @param movie Film à ajouter
     */
    public void addMovie(Movie movie) {
        if(this.movies.get(movie.getId()) == null) {
            this.movies.put(movie.getId(), movie);
            movie.addPerson(this);
        }
    }
}

package ch.hearc.ig.odi.movieapp.presentation.beans;

import ch.hearc.ig.odi.movieapp.services.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jeremy.barfuss
 */
@Named(value = "createMovieBean")
@RequestScoped
public class CreateMovieBean {

    @Inject
    Services services;
    private long id;
    private String name;
    private String producer;

    /**
     * Creates a new instance of CreateMovieBean
     */
    public CreateMovieBean() {
    }
    
    /**
     * Renvoie l'identifiant du film
     *
     * @return Identifiant du film
     */
    public long getId() {
        return id;
    }

    /**
     * Modifie l'identifiant du film
     *
     * @param id Nouvel identifiant du film
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Renvoie le nom du film
     *
     * @return Nom du film
     */
    public String getName() {
        return name;
    }

    /**
     * Modifie le nom du film
     *
     * @param name Nouveau nom du film
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Renvoie le producteur du film
     *
     * @return Producteur du film
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Modifie le producteur du film
     *
     * @param producer Nouveau producteur du film
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }
    
    public String addMovie() {
        services.addMovie(id, name, producer);
        return "/home.xhtml";
    }

}

package ch.hearc.ig.odi.movieapp.business;

import java.util.ArrayList;

/**
 *Classe métier de personne.
 * 
 * @author steven.habegger
 */
public class Movie {
    private long id;
    private String name;
    private String producer;
    private ArrayList<Person> persons;

    /**
     * Constructeur de film
     *
     * @param id Identifiant du film
     * @param name Titre du film
     * @param producer Nom du producteur
     */
    public Movie(long id, String name, String producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
    
    /**
     * Ajout d'une personne au film
     *
     * @param personToAdd Nouvel personne à ajouter au film
     */
    public void addPerson(Person personToAdd){
        persons.add(personToAdd);
    }
    
    /**
     * Suppression d'une personne au film
     *
     * @param personToRemove Personne à supprimer au film
     */
    public void removePerson(Person personToRemove){
        persons.remove(personToRemove);
    }
}

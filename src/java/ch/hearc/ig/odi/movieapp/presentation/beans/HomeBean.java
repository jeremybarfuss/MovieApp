package ch.hearc.ig.odi.movieapp.presentation.beans;

import ch.hearc.ig.odi.movieapp.business.Person;
import ch.hearc.ig.odi.movieapp.services.Services;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 * Bean de la page Home. Permet d'accéder aux listes de personnes et de clients
 *
 * @author jeremy.barfuss
 */
@Named(value = "homeBean")
@SessionScoped
public class HomeBean implements Serializable {

    @Inject
    Services services;

    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
    }

    /**
     * Renvoie la liste des personnes
     *
     * @return Liste des personnes
     */
    public List<Person> getPersons() {
        return services.getPeopleList();
    }

}

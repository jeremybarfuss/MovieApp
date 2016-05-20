package ch.hearc.ig.odi.movieapp.presentation.converters;

import ch.hearc.ig.odi.movieapp.business.Person;
import ch.hearc.ig.odi.movieapp.services.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author jeremy.barfuss
 */
@Named(value = "personLOVConverter")
@RequestScoped
public class PersonLOVConverter implements Converter {

    @Inject
    Services services;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return services.getPersonById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Person) value).getId());
    }

}

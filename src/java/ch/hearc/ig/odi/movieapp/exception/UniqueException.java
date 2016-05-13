package ch.hearc.ig.odi.movieapp.exception;

/**
 *
 * @author jeremy.barfuss
 */
public class UniqueException extends Exception {
    public UniqueException() {
        System.out.println("Cette personne a déjà vu ce film");
    }

}

package ecole.etudiant;

import java.util.Date;

/**
 * Classe d'un cours d'une session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class CoursEte extends Cours {
    private final int DUREE_SESSION = 8;

    private CoursEte(String p_departement, String p_numero, Date p_dateDebut) {
        super(p_departement, p_numero, p_dateDebut);
    }

    /**
     * Fabrique d'un cours
     *
     * @param p_departement Département du cours
     * @param p_numero Numéro d'un cours
     * @param p_dateDebut Date de début d'un cours
     * @return Un cours
     */
    static CoursEte creer(String p_departement, String p_numero, Date p_dateDebut) {
        CoursEte cours = new CoursEte(p_departement, p_numero, p_dateDebut);

        return cours;
    }


    protected int getDureeSession() {
        return DUREE_SESSION;
    }
}

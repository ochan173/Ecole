package ecole.etudiant;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe d'un cours d'une session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class CoursSession extends Cours {
    private static int m_compteurCours = 0;
    private final int DUREE_SESSION = 15;

    protected CoursSession(String p_departement, String p_numero, Date p_dateDebut) {
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
    public static CoursSession creer(String p_departement, String p_numero, Date p_dateDebut) {
        CoursSession cours = new CoursSession(p_departement, p_numero, p_dateDebut);
        m_compteurCours++;

        return cours;
    }

    static int getCompteur() { return m_compteurCours; }

    /**
     * Méthode pour réinitaliser le compteur de cours
     */
    static void reinitialiserCptCours() { m_compteurCours = 0; }

    protected int getDureeSession() {
        return DUREE_SESSION;
    }
}

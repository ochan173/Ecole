package ecole.etudiant;

import junit.framework.TestCase;

import java.util.Date;

import static ecole.etudiant.DateUtil.creerDate;

/**
 * Classe de test pour les cours session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestCoursSession extends TestCours {
    /**
     * Série de tests pour le nombre de cours ajoutés
     */
    public void testNombreCours() {
        CoursSession.reinitialiserCptCours();
        Date dateDebut = DateUtil.creerDate(2019, 3, 14);

        assertEquals(0, CoursSession.getCompteur());
        CoursSession.creer("Francais", "102", dateDebut);
        assertEquals(1,CoursSession.getCompteur());

        CoursSession.reinitialiserCptCours();
        assertEquals(0, CoursSession.getCompteur());
    }

    public void testDateFin() {
        Date dateDebut = DateUtil.creerDate(2019, 3, 14);
        Cours cours = creerCours("Philo", "101", dateDebut);
        Date dateQuinzeSemaines = DateUtil.creerDate(2019, 6, 28);

        assertEquals(dateQuinzeSemaines, cours.getDateFinSession());
    }

    protected Cours creerCours(String p_departement, String p_numero, Date p_dateDebut) {
        Cours coursSession = CoursSession.creer(p_departement, p_numero, p_dateDebut);
        return coursSession;
    }
}

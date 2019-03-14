package ecole.etudiant;

import java.util.Date;

/**
 * Classe de test pour les cours session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestCoursEte extends TestCours {
    public void testDateFin() {
        Date dateDebut = DateUtil.creerDate(2019, 3, 14);
        Cours cours = creerCours("Philo", "101", dateDebut);
        Date dateHuitSemaines = DateUtil.creerDate(2019, 5, 9);

        assertEquals(dateHuitSemaines, cours.getDateFinSession());
    }

    protected Cours creerCours(String p_departement, String p_numero, Date p_dateDebut) {
        Cours coursEte = CoursEte.creer(p_departement, p_numero, p_dateDebut);
        return coursEte;
    }
}

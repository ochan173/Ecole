package ecole.rapport;

import ecole.etudiant.CoursSession;
import ecole.etudiant.DateUtil;
import junit.framework.TestCase;


import java.util.Date;

import static ecole.rapport.ConstantesRapport.SAUT_LIGNE;

public class TestRapportCours extends TestCase {

    public void testRapport() {
        final Date date = DateUtil.creerDate(2019,2, 20);
        RapportCours rapport = new RapportCours();
        rapport.ajouter(CoursSession.creerCoursSession("Francais", "101", date, 2));
        rapport.ajouter(CoursSession.creerCoursSession("Math", "301", date, 3));
        rapport.ajouter(CoursSession.creerCoursSession("Philo", "301", date, 4));
        rapport.ajouter(CoursSession.creerCoursSession("Math", "201", date, 4));
        rapport.ajouter(CoursSession.creerCoursSession("Philo", "201", date, 4));

        assertEquals("Francais 101" + SAUT_LIGNE +
                "Math 201" + SAUT_LIGNE +
                "Math 301" + SAUT_LIGNE +
                "Philo 201" + SAUT_LIGNE +
                "Philo 301" + SAUT_LIGNE, rapport.getRapportCours());
    }
}

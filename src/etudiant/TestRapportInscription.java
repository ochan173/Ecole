package etudiant;

import junit.framework.TestCase;
import static etudiant.DateUtil.creerDate;

/**
 * Classe de tests pour la création d'un rapport d'inscription
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestRapportInscription extends TestCase {

    /**
     * Tests pour un rapport d'inscription
     */
    public void testRapportInscription() {
        CoursSession coursSession = CoursSession.CreerCoursSession("Philo", "101", creerDate(2019, 2, 7), 3);

        Etudiant etudiant1 = new Etudiant("Arianne f.", 9, "FR");
        Etudiant etudiant2 = new Etudiant("Paul n.", 6, "CA");

        coursSession.inscrire(etudiant1);
        coursSession.inscrire(etudiant2);

        assertEquals(RapportInscription.ENTETE_RAPPORT_INSCRIPTION
                + "Arianne f." + RapportInscription.SAUT_LIGNE
                + "Paul n." + RapportInscription.SAUT_LIGNE
                + RapportInscription.PIEDPAGE_RAPPORT_INSCRIPTION
                + "2" + RapportInscription.SAUT_LIGNE, new RapportInscription(coursSession).getRapportInscription());

    }
}

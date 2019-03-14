package ecole.rapport;

import ecole.etudiant.CoursSession;
import ecole.etudiant.Etudiant;
import junit.framework.TestCase;
import static ecole.etudiant.DateUtil.creerDate;
import static ecole.rapport.ConstantesRapport.SAUT_LIGNE;

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
        CoursSession coursSession = CoursSession.creer("Philo", "101", creerDate(2019, 2, 7));

        Etudiant etudiant1 = new Etudiant("Arianne f.", 9, "FR");
        Etudiant etudiant2 = new Etudiant("Paul n.", 6, "CA");

        coursSession.inscrire(etudiant1);
        coursSession.inscrire(etudiant2);

        assertEquals(RapportInscription.ENTETE_RAPPORT_INSCRIPTION
                + "Arianne f." + SAUT_LIGNE
                + "Paul n." + SAUT_LIGNE
                + RapportInscription.PIEDPAGE_RAPPORT_INSCRIPTION
                + "2" + SAUT_LIGNE, new RapportInscription(coursSession).getRapportInscription());

    }

}

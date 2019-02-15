package etudiant;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static etudiant.CoursSession.SAUT_LIGNE;

public class TestRapportInscription extends TestCase {
    public void testRapportInscription() {
        CoursSession coursSession = new CoursSession("Philo", "101", creerDate(2019, 2, 7));

        Etudiant etudiant1 = new Etudiant("Arianne f.", 9);
        Etudiant etudiant2 = new Etudiant("Paul n.", 6);

        coursSession.inscrire(etudiant1);
        coursSession.inscrire(etudiant2);

        assertEquals(RapportInscription.ENTETE_RAPPORT_INSCRIPTION
                + "Arianne f." + RapportInscription.SAUT_LIGNE
                + "Paul n." + RapportInscription.SAUT_LIGNE
                + RapportInscription.PIEDPAGE_RAPPORT_INSCRIPTION
                + "2" + RapportInscription.SAUT_LIGNE, new RapportInscription(coursSession).getRapportInscription());

    }

    private Date creerDate(int p_annee, int p_mois, int p_jour) {
        GregorianCalendar calendrier = new GregorianCalendar();
        calendrier.clear();

        calendrier.set(Calendar.YEAR, p_annee);
        calendrier.set(Calendar.MONTH, p_mois);
        calendrier.set(Calendar.DAY_OF_MONTH, p_jour);

        return calendrier.getTime();
    }
}

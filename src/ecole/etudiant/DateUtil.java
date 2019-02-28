package ecole.etudiant;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe pour créer une date
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class DateUtil {

    private DateUtil() { }

    /**
     * Méthode pour créer une date
     * @param p_annee Année
     * @param p_mois Mois de l'année commencant à 0
     * @param p_jour Jour du mois
     * @return une date
     */
     public static Date creerDate(int p_annee, int p_mois, int p_jour) {
        GregorianCalendar calendrier = new GregorianCalendar();
        calendrier.clear();

        calendrier.set(Calendar.YEAR, p_annee);
        calendrier.set(Calendar.MONTH, p_mois);
        calendrier.set(Calendar.DAY_OF_MONTH, p_jour);

        return calendrier.getTime();
    }
}

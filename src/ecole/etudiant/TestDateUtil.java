package ecole.etudiant;

import junit.framework.TestCase;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static ecole.etudiant.DateUtil.creerDate;

/**
 * Classe pour la création d'une date
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestDateUtil extends TestCase {

    /**
     * Suite de tests pour la création d'une date
     */
    public void testCreer() {
        Date date = creerDate(2019, 2, 14);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        assertEquals(2019, calendar.get(Calendar.YEAR));
        assertEquals(2, calendar.get(Calendar.MONTH));
        assertEquals(14, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public void testDateInvalide() {
        try {
            Date date = creerDate(2019, 200, 14);
            fail("Date invalide");
        }
        catch (FormatDateCoursException e) {

        }
    }
}

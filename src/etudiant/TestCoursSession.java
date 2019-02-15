package etudiant;

import junit.framework.TestCase;

import java.util.Date;

import static etudiant.DateUtil.creerDate;

public class TestCoursSession extends TestCase {
    private CoursSession m_coursSession;
    private Date m_date;

    public void setUp() {
        CoursSession.reinitialiserCptCours();
        m_date = creerDate(2019, 2, 7);
        m_coursSession = new CoursSession("Philo", "101", m_date);
    }

    public void testCreer() {
        assertEquals("Philo", m_coursSession.getDepartement());
        assertEquals("101", m_coursSession.getNumero());
        assertEquals(m_date, m_coursSession.getDateDebut());

        assertEquals(0, m_coursSession.getNbEleves());

    }

    public void testNombreCours() {
        assertEquals(1, m_coursSession.getNbCours());
        m_coursSession = new CoursSession("Francais", "102", m_date);
        assertEquals(2, m_coursSession.getNbCours());

        CoursSession.reinitialiserCptCours();
        assertEquals(0, m_coursSession.getNbCours());
    }

    public void testInscrireEtudiant() {

        Etudiant etudiant1 = new Etudiant("Olivier Chan", 12);
        m_coursSession.inscrire(etudiant1);

        assertEquals(etudiant1, m_coursSession.getEtudiant(0));

        Etudiant etudiant2 = new Etudiant("Patrick n.", 9);
        m_coursSession.inscrire(etudiant2);
        assertEquals(2, m_coursSession.getNbEleves());
        assertEquals(etudiant1, m_coursSession.getEtudiant(0));
        assertEquals(etudiant2, m_coursSession.getEtudiant(1));


    }



}

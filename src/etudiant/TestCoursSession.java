package etudiant;

import junit.framework.TestCase;

import java.util.Date;

import static etudiant.DateUtil.creerDate;

/**
 * Classe de test pour les cours session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestCoursSession extends TestCase {
    private CoursSession m_coursSession;
    private Date m_date;

    /**
     * Classe pour initialiser les variable avant les tests
     */
    public void setUp() {
        CoursSession.reinitialiserCptCours();
        m_date = creerDate(2019, 2, 7);
        m_coursSession = CoursSession.CreerCoursSession("Philo", "101", m_date,3);
    }

    /**
     * Série de tests pour la création d'un cours
     */
    public void testCreer() {
        assertEquals("Philo", m_coursSession.getDepartement());
        assertEquals("101", m_coursSession.getNumero());
        assertEquals(m_date, m_coursSession.getDateDebut());

        assertEquals(0, m_coursSession.getNbEleves());

    }

    /**
     * Série de tests pour le nombre de cours ajoutés
     */
    public void testNombreCours() {
        assertEquals(1, m_coursSession.getNbCours());
        m_coursSession =  CoursSession.CreerCoursSession("Francais", "102", m_date, 4);
        assertEquals(2, m_coursSession.getNbCours());

        CoursSession.reinitialiserCptCours();
        assertEquals(0, m_coursSession.getNbCours());
    }

    /**
     * Série de tests pour inscrire un étudiant à des cours
     */
    public void testInscrireEtudiant() {
        CoursSession coursMath = CoursSession.CreerCoursSession("Math", "101", m_date, 2);
        Etudiant etudiant1 = new Etudiant("Olivier Chan", 12, "CA");
        assertEquals(12, etudiant1.getNbUnites());
        coursMath.inscrire(etudiant1);
        assertEquals(14, etudiant1.getNbUnites());

        assertEquals(etudiant1, coursMath.getEtudiant(0));

        Etudiant etudiant2 = new Etudiant("Patrick n.", 9, "US");
        coursMath.inscrire(etudiant2);
        assertEquals(2, coursMath.getNbEleves());
        assertEquals(etudiant1, coursMath.getEtudiant(0));
        assertEquals(etudiant2, coursMath.getEtudiant(1));


    }



}

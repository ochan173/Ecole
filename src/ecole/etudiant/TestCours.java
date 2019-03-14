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
abstract class TestCours extends TestCase {
    private Cours m_cours;
    private Date m_date;

    /**
     * Classe pour initialiser les variable avant les tests
     */
    public void setUp() {
        m_date = creerDate(2019, 2, 7);
        m_cours = CoursSession.creer("Philo", "101", m_date);
    }

    abstract protected Cours creerCours(String p_departement, String p_numero, Date p_dateDebut);

    /**
     * Série de tests pour la création d'un cours
     */
    public void testCreer() {
        assertEquals("Philo", m_cours.getDepartement());
        assertEquals("101", m_cours.getNumero());
        assertEquals(m_date, m_cours.getDateDebut());

        assertEquals(0, m_cours.getNbEleves());

    }

    /**
     * Série de tests pour inscrire un étudiant à des cours
     */
    public void testInscrireEtudiant() {
        Cours coursMath = creerCours("Math", "101", m_date);
        coursMath.setNbUnite(2);
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
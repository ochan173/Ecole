package ecole.etudiant;

import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void testMoyenneElevesTempsPartiel() {
        Cours coursMath = creerCours("Math", "101", m_date);
        assertEquals(0.0, coursMath.getMoyenneEleveTempsPartiel());

        Etudiant etudiant1 = new Etudiant("Olivier Chan", 12, "CA");
        etudiant1.ajouterNote(Etudiant.Note.A);
        Etudiant etudiant2 = new Etudiant("David Goulet", 5, "CA");
        etudiant2.ajouterNote(Etudiant.Note.B);
        Etudiant etudiant3 = new Etudiant("Axel Berg", 3, "CA");
        etudiant3.ajouterNote(Etudiant.Note.C);

        etudiant1.setStrategiePointage(new StrategiePointageBase());
        etudiant2.setStrategiePointage(new StrategiePointageBase());
        etudiant3.setStrategiePointage(new StrategiePointageBase());

        coursMath.inscrire(etudiant1);
        coursMath.inscrire(etudiant2);
        coursMath.inscrire(etudiant3);

        assertEquals(2.5, coursMath.getMoyenneEleveTempsPartiel());
        etudiant2.ajouterNote(Etudiant.Note.A);
        assertEquals(4.5, coursMath.getMoyenneEleveTempsPartiel());
    }

    public void testIterable() {
        List<Etudiant> etudiants = new ArrayList<>();

        Cours coursMath = creerCours("Math", "101", m_date);

        Etudiant etudiant1 = new Etudiant("Olivier Chan", 12, "CA");
        Etudiant etudiant2 = new Etudiant("David Goulet", 5, "CA");
        Etudiant etudiant3 = new Etudiant("Axel Berg", 3, "CA");

        coursMath.inscrire(etudiant1);
        coursMath.inscrire(etudiant2);
        coursMath.inscrire(etudiant3);

        for (Etudiant e : coursMath) {
            etudiants.add(e);
        }

        assertEquals(coursMath.getTousEtudiants(), etudiants);
    }

    public void testUrl() throws MalformedURLException {
        final String url = "http://www.cstjean.qc.ca";
        m_cours.setUrl(url);
        assertEquals(url, m_cours.getUrl().toString());
    }

    public void testUrlInvalide() {
        final String url = "????**//ww.cstjean.qc.ca";

        try {
            m_cours.setUrl(url);
            fail("Mauvais format de url");
        }
        catch (MalformedURLException p_reussite) {
            //Réussite
        }
    }
}

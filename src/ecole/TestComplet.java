package ecole;

import ecole.etudiant.TestCoursSession;
import ecole.etudiant.TestDateUtil;
import ecole.etudiant.TestEtudiant;
import ecole.rapport.TestRapportCours;
import ecole.rapport.TestRapportInscription;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Classe de tests complet à exécuter
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestComplet extends TestCase {
    /**
     * Suite des tests exécutés
     * @return une suite de tests
     */
    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.addTest(ecole.etudiant.TestCompletEtudiant.suite());
        testSuite.addTest(ecole.rapport.TestCompletRapport.suite());
        return testSuite;
}
}

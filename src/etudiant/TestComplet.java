package etudiant;

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
        testSuite.addTestSuite(TestEtudiant.class);
        testSuite.addTestSuite(TestCoursSession.class);
        testSuite.addTestSuite(TestRapportInscription.class);
        testSuite.addTestSuite(TestDateUtil.class);
        return testSuite;
    }
}

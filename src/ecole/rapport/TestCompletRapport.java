package ecole.rapport;

import junit.framework.TestSuite;

public class TestCompletRapport {

    /**
     * Suite des tests exécutés
     * @return une suite de tests
     */
    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestSuite(TestRapportInscription.class);
        testSuite.addTestSuite(TestRapportCours.class);
        return testSuite;
    }
}

package etudiant;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestComplet extends TestCase {
    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestSuite(TestEtudiant.class);
        testSuite.addTestSuite(TestCoursSession.class);
        testSuite.addTestSuite(TestRapportInscription.class);
        testSuite.addTestSuite(TestDateUtil.class);
        return testSuite;
    }
}

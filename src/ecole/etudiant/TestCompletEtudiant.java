package ecole.etudiant;

import ecole.rapport.TestRapportCours;
import ecole.rapport.TestRapportInscription;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestCompletEtudiant extends TestCase {
    /**
     * Suite des tests exécutés
     * @return une suite de tests
     */
    public static TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestSuite(TestEtudiant.class);
        testSuite.addTestSuite(TestCoursSession.class);
        testSuite.addTestSuite(TestCoursEte.class);
        testSuite.addTestSuite(TestDateUtil.class);
        testSuite.addTestSuite(TestStrategiePoints.class);
        testSuite.addTestSuite(TestStrategiePointsDifficile.class);
        testSuite.addTestSuite(TestNotesUtil.class);
        return testSuite;
    }
    }

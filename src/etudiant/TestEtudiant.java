package etudiant;

import junit.framework.TestCase;

public class TestEtudiant extends TestCase {
    public void testCreer() {
        String nomEtudiant = "Olivier Chan";
        Etudiant etudiant = new Etudiant(nomEtudiant, 12);
        assertEquals(nomEtudiant, etudiant.getNom());
        assertTrue(etudiant.estTempsPlein());
        assertEquals(12, etudiant.getNbUnites());

        String nomEtudiant2 = "Bob";
        Etudiant etudiant2 = new Etudiant(nomEtudiant2, 3);
        assertEquals(nomEtudiant2, etudiant2.getNom());
        assertFalse(etudiant2.estTempsPlein());
        assertEquals(3, etudiant2.getNbUnites());

        assertEquals(nomEtudiant, etudiant.getNom());
    }

}

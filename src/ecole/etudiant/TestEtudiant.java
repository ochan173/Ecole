package ecole.etudiant;

import junit.framework.TestCase;

/**
 * Classe de tests pour un Étudiant
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class TestEtudiant extends TestCase {
    static final double TOLERENCE_NOTE = 0.5;

    /**
     * Suite de tests pour la création d'un étudiant
     */
    public void testCreer() {
        String nomEtudiant = "Olivier Chan Weng";
        Etudiant etudiant = new Etudiant(nomEtudiant, 12, "CA");
        assertEquals(nomEtudiant, etudiant.getNomComplet());
        assertTrue(etudiant.estTempsPlein());
        assertTrue(etudiant.estCanadien());
        assertEquals(12, etudiant.getNbUnites());

        String nomEtudiant2 = "Bob b";
        Etudiant etudiant2 = new Etudiant(nomEtudiant2, 3, "US");
        assertEquals(nomEtudiant2, etudiant2.getNomComplet());
        assertFalse(etudiant2.estTempsPlein());
        assertFalse(etudiant2.estCanadien());
        assertEquals(3, etudiant2.getNbUnites());

        assertEquals(nomEtudiant, etudiant.getNomComplet());
    }

    public void testNomInvalide() {
        String nomEtudiant = "Gabriel Trudeau St Hilaire";
        try {
            Etudiant etudiant = new Etudiant(nomEtudiant, 12, "CA");
            fail("Format du nom invalide");
        }
        catch (FormatNomEtudiantException p_reussite) {
            //Réussite
            assertEquals("Format du nom invalide", p_reussite.getMessage());
        }
    }

    public void testUnite() {
        String nomEtudiant = "Olivier Chan";
        Etudiant etudiant = new Etudiant(nomEtudiant, 12, "CA");

        assertTrue(etudiant.estTempsPlein());
        assertTrue(etudiant.estCanadien());
        assertEquals(12, etudiant.getNbUnites());
    }

    public  void testMoyenne() {
        Etudiant etudiant = new Etudiant("David Gouet", 3, "CA");
        etudiant.setStrategiePointage(new StrategiePointageBase());

        assertEquals(0.0, etudiant.getMoyenne(), TOLERENCE_NOTE);
        etudiant.ajouterNote(Etudiant.Note.A);
        assertEquals(4.0, etudiant.getMoyenne(), TOLERENCE_NOTE);

        etudiant.ajouterNote(Etudiant.Note.B);
        assertEquals(3.5, etudiant.getMoyenne(), TOLERENCE_NOTE);

        etudiant.ajouterNote(Etudiant.Note.C);
        assertEquals(3.0, etudiant.getMoyenne(), TOLERENCE_NOTE);

        etudiant.ajouterNote(Etudiant.Note.D);
        assertEquals(2.5, etudiant.getMoyenne(), TOLERENCE_NOTE);

        etudiant.ajouterNote(Etudiant.Note.E);
        assertEquals(2.0, etudiant.getMoyenne(), TOLERENCE_NOTE);


        Etudiant etudiant2 = new Etudiant("Alex A", 3, "CA");
        etudiant2.setStrategiePointage(new StrategiePointageDifficile());
        assertEquals(0.0, etudiant2.getMoyenne(), TOLERENCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.A);
        assertEquals(5.0, etudiant2.getMoyenne(), TOLERENCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.B);
        assertEquals(4.5, etudiant2.getMoyenne(), TOLERENCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.C);
        assertEquals(4.0, etudiant2.getMoyenne(), TOLERENCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.D);
        assertEquals(3.5, etudiant2.getMoyenne(), TOLERENCE_NOTE);

        etudiant2.ajouterNote(Etudiant.Note.E);
        assertEquals(2.8, etudiant2.getMoyenne(), TOLERENCE_NOTE);
    }
}

package ecole.etudiant;

import junit.framework.TestCase;

public class TestNotesUtil extends TestCase {
    public void testSaisieNote() {
        assertEquals(75, NoteUtil.convertirNote("75"));
    }

    public void testMauvaiseNote() {
        try {
            NoteUtil.convertirNote("abcd");
            fail("Mauvais format de note");
        }
        catch (NumberFormatException p_reussite) {
            //Réussite
        }
    }

    public void testEstValide() {
        assertTrue(NoteUtil.estValide("23"));
        assertFalse(NoteUtil.estValide("sdfs"));
    }
}

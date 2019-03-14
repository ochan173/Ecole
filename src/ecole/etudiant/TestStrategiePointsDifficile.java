package ecole.etudiant;

import junit.framework.TestCase;

public class TestStrategiePointsDifficile extends TestCase {
    public void testDesPoints() {
        StrategiePointage strategie = new StrategiePointageDifficile();
        assertEquals(5, strategie.getNombrePointsPourNote(Etudiant.Note.A));
        assertEquals(4, strategie.getNombrePointsPourNote(Etudiant.Note.B));
        assertEquals(3, strategie.getNombrePointsPourNote(Etudiant.Note.C));
        assertEquals(2, strategie.getNombrePointsPourNote(Etudiant.Note.D));
        assertEquals(0, strategie.getNombrePointsPourNote(Etudiant.Note.E));
    }
}

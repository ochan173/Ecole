package ecole.etudiant;

import junit.framework.TestCase;

public class TestStrategiePoints extends TestCase {
    public void testDesPoints() {
        StrategiePointage strategie = new StrategiePointageBase();
        assertEquals(4, strategie.getNombrePointsPourNote(Etudiant.Note.A));
        assertEquals(3, strategie.getNombrePointsPourNote(Etudiant.Note.B));
        assertEquals(2, strategie.getNombrePointsPourNote(Etudiant.Note.C));
        assertEquals(1, strategie.getNombrePointsPourNote(Etudiant.Note.D));
        assertEquals(0, strategie.getNombrePointsPourNote(Etudiant.Note.E));
    }
}

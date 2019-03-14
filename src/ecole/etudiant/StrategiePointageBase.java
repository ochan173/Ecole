package ecole.etudiant;

public class StrategiePointageBase implements StrategiePointage {
    @Override
    public int getNombrePointsPourNote(Etudiant.Note p_note) {
            return p_note.getPoints();
        }
    }


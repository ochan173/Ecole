package ecole.etudiant;

public class StrategiePointageDifficile implements StrategiePointage {
    @Override
    public int getNombrePointsPourNote(Etudiant.Note p_note) {
        switch (p_note) {
            case  A : return 5;
            case  B : return 4;
            case  C : return 3;
            case  D : return  2;
                default: return 0;
        }
    }
}

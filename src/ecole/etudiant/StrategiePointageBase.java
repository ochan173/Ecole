package ecole.etudiant;

public class StrategiePointageBase implements StrategiePointage {
    @Override
    public int getNombrePointsPourNote(Etudiant.Note p_note) {
        switch (p_note) {
            case  A : return 4;
            case  B : return 3;
            case  C : return 2;
            case  D : return  1;
                default: return 0;
        }
    }
}

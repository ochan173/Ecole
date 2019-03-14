package ecole.etudiant;

public class StrategiePointageDifficile extends StrategiePointageBase {
    @Override
    public int getNombrePointsPourNote(Etudiant.Note p_note) {
        int points = super.getNombrePointsPourNote(p_note);

        if (points > 0) {
            points += 1;
        }

        return points;
    }
}

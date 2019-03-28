package ecole.etudiant;

class NoteUtil {
    static int convertirNote(String p_note) {
        return Integer.parseInt(p_note);
    }

    static boolean estValide(String p_note) {
        try {
            Integer.parseInt(p_note);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}

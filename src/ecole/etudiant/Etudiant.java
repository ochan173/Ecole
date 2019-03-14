package ecole.etudiant;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'un étudiant
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class Etudiant {
    enum Note {
        A(4),
        B(3),
        C(2),
        D(1),
        E(0);

        private int m_points;
        Note (int p_points) {
            m_points = p_points;
        }

        int getPoints() {
            return m_points;
        }
    }

    static final int UNITEE_POUR_TEMPS_PLEIN = 9;
    private String m_nom;
    private int m_nbUnites;
    private String m_pays;
    private List<Note> m_notes = new ArrayList<>();
    private StrategiePointage m_strategiePointage = new StrategiePointageBase();

    /**
     * Constructeur de base d'un étudiant
     *
     * @param p_nom Nom de l'étudiant
     * @param p_nbUnites Nombre d'unité que possède l'étudiant
     * @param p_pays Pays d'origine de l'étudiant
     */
       public Etudiant(String p_nom, int p_nbUnites, String p_pays) {
        m_nom = p_nom;
        m_nbUnites = p_nbUnites;
        m_pays = p_pays;
    }

    public String getNom() {
        return m_nom;
    }

    /**
     * Vérifie que l'étudiant étudit à temps plein
     * @return que l'étudiant a plus que 9 unités à son horaire
     */
    boolean estTempsPlein() { return m_nbUnites >= UNITEE_POUR_TEMPS_PLEIN; }

    int getNbUnites() { return m_nbUnites; }

    /**
     * Ajouter des unités à l'étudiant
     * @param p_unite Nom d'unités ajoutées à l'étudiant
     */
    void ajouterUnites(int p_unite) { m_nbUnites += p_unite; }

    /**
     * Vérifie que le paus d'origine de l'étudiant est le Canada
     * @return que l'étudiant est canadien
     */
    boolean estCanadien() { return m_pays.toLowerCase().equals("ca"); }

    void ajouterNote(Note p_note) {
        m_notes.add(p_note);
    }

    void setStrategiePointage(StrategiePointage p_strategiePointage) {
        m_strategiePointage = p_strategiePointage;
    }

    double getMoyenne() {
        if (m_notes.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;

        for (Note note : m_notes) {
            total += m_strategiePointage.getNombrePointsPourNote(note);
        }

        return total / m_notes.size();
    }
}

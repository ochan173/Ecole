package etudiant;

public class Etudiant {
    private String m_nom;
    private int m_nbUnites;

    Etudiant(String p_nom, int p_nbUnites) {
        m_nom = p_nom;
        m_nbUnites = p_nbUnites;
    }

    String getNom() {
        return m_nom;
    }

    boolean estTempsPlein() { return m_nbUnites >= 9; }

    int getNbUnites() { return m_nbUnites; }
}

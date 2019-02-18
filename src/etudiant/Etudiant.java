package etudiant;

/**
 * Classe d'un étudiant
 *
 * @author Olivier Chan
 * @author David Goulet
 */
class Etudiant {
    private String m_nom;
    private int m_nbUnites;
    private String m_pays;

    /**
     * Constructeur de base d'un étudiant
     *
     * @param p_nom Nom de l'étudiant
     * @param p_nbUnites Nombre d'unité que possède l'étudiant
     * @param p_pays Pays d'origine de l'étudiant
     */
    Etudiant(String p_nom, int p_nbUnites, String p_pays) {
        m_nom = p_nom;
        m_nbUnites = p_nbUnites;
        m_pays = p_pays;
    }

    String getNom() {
        return m_nom;
    }

    /**
     * Vérifie que l'étudiant étudit à temps plein
     * @return que l'étudiant a plus que 9 unités à son horaire
     */
    boolean estTempsPlein() { return m_nbUnites >= 9; }

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
}

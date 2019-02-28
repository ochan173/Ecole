package ecole.etudiant;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe d'un cours d'une session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
public class CoursSession implements Comparable<CoursSession> {
    private String m_departement;
    private String m_numero;
    private ArrayList<Etudiant> m_etudiants = new ArrayList<>();
    private Date m_dateDebut;
    private static int m_compteurCours = 0;
    private int m_unite;

    private CoursSession(String p_departement, String p_numero, Date p_dateDebut) {
        m_departement= p_departement;
        m_numero = p_numero;
        m_dateDebut = p_dateDebut;
    }

    /**
     * Fabrique d'un cours
     *
     * @param p_departement Département du cours
     * @param p_numero Numéro d'un cours
     * @param p_dateDebut Date de début d'un cours
     * @param p_unite Nombre d'unités d'un cours
     * @return Un cours
     */
    public static CoursSession creerCoursSession(String p_departement, String p_numero, Date p_dateDebut, int p_unite) {
        CoursSession cours = new CoursSession(p_departement, p_numero, p_dateDebut);
        cours.setUnite(p_unite);
        m_compteurCours++;

        return cours;
    }

    private void setUnite(int p_unite) {
        this.m_unite = p_unite;
    }

    public ArrayList<Etudiant> getTousEtudiants() {
        return m_etudiants;
    }

    public String getDepartement() {
        return  m_departement;
    }

    public String getNumero() {
        return m_numero;
    }

    public int getNbEleves() {
        return  m_etudiants.size();
    }

    /**
     * Méthode pour inscrire un étudiant à un cours
     * @param p_etudiant Étudiant à inscrire
     */
    public void inscrire(Etudiant p_etudiant) {
        p_etudiant.ajouterUnites(m_unite);
        m_etudiants.add(p_etudiant);
    }

    Etudiant getEtudiant(int p_indice) {
        return m_etudiants.get(p_indice);
    }

    Date getDateDebut() {
        return  m_dateDebut;
    }

    int getNbCours() { return m_compteurCours; }

    /**
     * Méthode pour réinitaliser le compteur de cours
     */
    static void reinitialiserCptCours() { m_compteurCours = 0; }

    @Override
    public int compareTo(CoursSession p_cours) {
        int compareDepartement = this.getDepartement().compareTo(p_cours.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return this.getNumero().compareTo(p_cours.getNumero());
    }
}

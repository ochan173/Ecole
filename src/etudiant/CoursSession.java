package etudiant;

import java.util.ArrayList;
import java.util.Date;
import java.util.PropertyResourceBundle;

class CoursSession {
    static final String SAUT_LIGNE =  System.getProperty("line.separator");
    static final String ENTETE_RAPPORT_INSCRIPTION = "Étudiants" + "\n";
    static final String PIEDPAGE_RAPPORT_INSCRIPTION = "\n" + "# Étuidants = ";

    private String m_departement;
    private String m_numero;
    private ArrayList<Etudiant> m_etudiants = new ArrayList<>();
    private Date m_dateDebut;
    private static int m_compteurCours = 0;

    CoursSession(String p_departement, String p_numero, Date p_dateDebut) {
        m_departement= p_departement;
        m_numero = p_numero;
        m_dateDebut = p_dateDebut;
        m_compteurCours++;
    }

    ArrayList<Etudiant> getTousEtudiants() {
        return m_etudiants;
    }

    String getDepartement() {
        return  m_departement;
    }

    String getNumero() {
        return m_numero;
    }

    int getNbEleves() {
        return  m_etudiants.size();
    }

    void inscrire(Etudiant p_etudiant) {
        m_etudiants.add(p_etudiant);
    }

    Etudiant getEtudiant(int p_indice) {
        return m_etudiants.get(p_indice);
    }

    Date getDateDebut() {
        return  m_dateDebut;
    }

    int getNbCours() { return m_compteurCours; }

    static void reinitialiserCptCours() { m_compteurCours = 0; }
}

package ecole.etudiant;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;

/**
 * Classe d'un cours d'une session
 *
 * @author Olivier Chan
 * @author David Goulet
 */
abstract class Cours implements Comparable<Cours>, Iterable<Etudiant> {
    private String m_departement;
    private String m_numero;
    private ArrayList<Etudiant> m_etudiants = new ArrayList<>();
    private Date m_dateDebut;
    private int m_unite;
    private URL m_url;

    Cours(String p_departement, String p_numero, Date p_dateDebut) {
        m_departement= p_departement;
        m_numero = p_numero;
        m_dateDebut = p_dateDebut;
    }

    @Override
    public Iterator<Etudiant> iterator() {
        return m_etudiants.iterator();
    }

    public void setNbUnite(int p_unite) {
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

    @Override
    public int compareTo(Cours p_cours) {
        int compareDepartement = this.getDepartement().compareTo(p_cours.getDepartement());

        if (compareDepartement != 0) {
            return compareDepartement;
        }

        return this.getNumero().compareTo(p_cours.getNumero());
    }

    double getMoyenneEleveTempsPartiel() {
        int cptElevesTempsPartiels = 0;
        double totalNotes = 0.0;

        if (getNbEleves() == 0) {
            return  0.0;
        }

        for (Etudiant e : m_etudiants) {
            if (!e.estTempsPlein()) {
                for (Etudiant.Note note : e.getNotes()) {
                    totalNotes += note.getPoints();
                }
                cptElevesTempsPartiels++;
            }
        }
        totalNotes /= cptElevesTempsPartiels;
        return totalNotes;
    }

    abstract protected int getDureeSession();

    Date getDateFinSession() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(m_dateDebut);

        calendar.add(Calendar.DAY_OF_YEAR, getDureeSession() * 7);

        return  calendar.getTime();
    }

    public URL getUrl() {
        return m_url;
    }

    public void setUrl(String p_url) throws MalformedURLException {
        m_url = new URL(p_url);
    }
}

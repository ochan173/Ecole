package etudiant;

/**
 * Création d'un rapport pour les inscriptions d'un cours
 *
 * @author Olivier Chan
 * @author David Goulet
 */
class RapportInscription {
    /**
     * Saut de ligne
     */
    static final String SAUT_LIGNE =  System.getProperty("line.separator");

    /**
     * En-tête du rapport
     */
    static final String ENTETE_RAPPORT_INSCRIPTION = "Étudiants" + "\n";

    /**
     * Pied de page du rapport
     */
    static final String PIEDPAGE_RAPPORT_INSCRIPTION = "\n" + "# Étuidants = ";

    private CoursSession m_coursSession;

    /**
     * Rapport de base
     * @param p_coursSession Cours sur leque se base le rapport
     */
    RapportInscription(CoursSession p_coursSession) {
        m_coursSession = p_coursSession;
    }

    /**
     * Création du rapport
     * @return rapport des inscriptions
     */
    String getRapportInscription() {
        StringBuilder builder = new StringBuilder();
        builder.append(ENTETE_RAPPORT_INSCRIPTION);
        for (Etudiant etudiant: m_coursSession.getTousEtudiants()) {
            builder.append(etudiant.getNom());
            builder.append(SAUT_LIGNE);
        }

        builder.append(PIEDPAGE_RAPPORT_INSCRIPTION);
        builder.append(m_coursSession.getNbEleves());
        builder.append(SAUT_LIGNE);

        return  builder.toString();
    }
}

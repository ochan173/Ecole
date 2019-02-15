package etudiant;

class RapportInscription {
    static final String SAUT_LIGNE =  System.getProperty("line.separator");

    static final String ENTETE_RAPPORT_INSCRIPTION = "Étudiants" + "\n";
    static final String PIEDPAGE_RAPPORT_INSCRIPTION = "\n" + "# Étuidants = ";

    private CoursSession m_coursSession;
    RapportInscription(CoursSession p_coursSession) {
        m_coursSession = p_coursSession;
    }

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

package ecole.etudiant;

class FormatNomEtudiantException extends IllegalArgumentException {
    private String m_message;
    FormatNomEtudiantException(String p_messgae) {
        super(p_messgae);
        m_message = p_messgae;
    }

    @Override
    public String getMessage() {
        return m_message;
    }
}

package ecole.rapport;

import ecole.etudiant.CoursSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ecole.rapport.ConstantesRapport.SAUT_LIGNE;

class RapportCours {

    private List<CoursSession> m_coursSessions = new ArrayList<>();

     void ajouter(CoursSession p_coursSession) {
        m_coursSessions.add(p_coursSession);
    }

    String getRapportCours() {
        StringBuilder builder = new StringBuilder();

        Collections.sort(m_coursSessions);

        for (CoursSession cours : m_coursSessions) {
            builder.append(cours.getDepartement());
            builder.append(" ");
            builder.append(cours.getNumero());
            builder.append(SAUT_LIGNE);
        }
        return builder.toString();
    }
}

package school.hei.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Etudiant {
    private final String id;
    private final String nom;
    private final String prenom;
    private final LocalDate dateEntreChezHEI;
    private Groupe groupe;

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public void fairePayment(Payment payment, Frais frais){
        
    }

}

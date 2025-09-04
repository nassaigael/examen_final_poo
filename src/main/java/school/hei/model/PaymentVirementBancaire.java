package school.hei.model;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentVirementBancaire extends Payment {
    private final String numeroDeCompteBancaireEcole;

    public PaymentVirementBancaire(String id, double montant, Instant dateHeureDePayment, String numeroDeCompteBancaireEcole) {
        super(id, montant, dateHeureDePayment);
        this.numeroDeCompteBancaireEcole = numeroDeCompteBancaireEcole;
    }
    
}

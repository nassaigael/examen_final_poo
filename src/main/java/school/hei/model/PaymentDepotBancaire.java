package school.hei.model;

import java.time.Instant;

public class PaymentDepotBancaire extends PaymentVirementBancaire {

    public PaymentDepotBancaire(String id, double montant, Instant dateHeureDePayment,
            String numeroDeCompteBancaireEcole) {
        super(id, montant, dateHeureDePayment, numeroDeCompteBancaireEcole);
    }

    
}

package school.hei.model;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMobileMoney extends Payment{
    private final String numeroDeTelephoneEnvoyer;

    public PaymentMobileMoney(String id, double montant, Instant dateHeureDePayment, String numeroDeTelephoneEnvoyer) {
        super(id, montant, dateHeureDePayment);
        this.numeroDeTelephoneEnvoyer = numeroDeTelephoneEnvoyer;
    }
    
}

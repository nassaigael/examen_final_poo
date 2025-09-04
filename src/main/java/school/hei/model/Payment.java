package school.hei.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Payment {
    private final String id;
    private final double montant;
    private final Instant dateHeureDePayment;
}

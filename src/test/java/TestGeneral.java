import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import school.hei.model.Etudiant;
import school.hei.model.Frais;
import school.hei.model.FraisStatus;
import school.hei.model.Groupe;
import school.hei.model.Payment;
import school.hei.model.PaymentMobileMoney;
import school.hei.model.Statistics;

public class TestGeneral {

        @Test
        void testStatusFrais() {
        Groupe groupeTest = new Groupe("01", "K3");
        Etudiant s = new Etudiant("1", "Jean", "Dupont", LocalDate.now(), groupeTest);
        Frais frais = new Frais("01", "Tuition", 1000, Instant.now().plusSeconds(3600), s);

        frais.ajouterPayement(new Payment("1", 500, Instant.now()));
        assertEquals(FraisStatus.IN_PROGRESS, frais.statusFrais(Instant.now()));

        frais.ajouterPayement(new Payment("2", 500, Instant.now()));
        assertEquals(FraisStatus.PAID, frais.statusFrais(Instant.now()));

        frais.ajouterPayement(new Payment("3", 100, Instant.now()));
        assertEquals(FraisStatus.OVERPAID, frais.statusFrais(Instant.now()));

       Frais fraisRetard = new Frais("2", "Frais en retard", 1000, Instant.now().minusSeconds(3600), s);
        fraisRetard.ajouterPayement(new Payment("", 200, Instant.now()));
        assertEquals(FraisStatus.LATE, fraisRetard.statusFrais(Instant.now()));
    }

    @Test
    void testStatistics() {
        Groupe groupeTest = new Groupe("01", "K3");
        Etudiant s1 = new Etudiant("01", "Jean", "Dupont", LocalDate.now(), groupeTest);
       Frais frais1 = new Frais("1", "Tuition", 1000, Instant.now().minusSeconds(3600), s1);
        frais1.ajouterPayement(new PaymentMobileMoney("01", 200, Instant.now(), "0342837614"));
       Frais frais2 = new Frais("2", "Tuition2", 500, Instant.now().plusSeconds(3600), s1);
        frais2.ajouterPayement(new PaymentMobileMoney("02", 500, Instant.now(), "0342837614"));

        List<Frais> frais = List.of(frais1, frais2);

        List<Frais> retard = Statistics.getLateFees(frais, Instant.now());
        assertEquals(1, retard.size());
        assertEquals(frais1, retard.get(0));

        double missing = Statistics.getTotalMissingFees(frais, Instant.now());
        assertEquals(800, missing);

        double totalPaid = Statistics.getTotalPaidByStudent(s1, frais, Instant.now());
        assertEquals(700, totalPaid);
    }
}

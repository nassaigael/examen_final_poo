package school.hei.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// @AllArgsConstructor
@Getter
public class Frais {
    private final String id;
    private final String label;
    private final double montantAPayer;
    private final Instant deadline;
    private Etudiant etudiantConcerne;
    private List<Payment> payments;

    public Frais(String id, String label, double montantAPayer, Instant deadline, Etudiant etudiantConcerne) {
        this.id = id;
        this.label = label;
        this.montantAPayer = montantAPayer;
        this.deadline = deadline;
        this.etudiantConcerne = etudiantConcerne;
        this.payments = new ArrayList<>();
    }

    public void ajouterPayement(Payment payment){
        payments.add(payment);
    }

    public FraisStatus statusFrais(Instant temps) {
        double totalPaye = payments.stream().mapToDouble(Payment::getMontant).sum();

        if (totalPaye == 0) return FraisStatus.IN_PROGRESS;
        if(totalPaye > montantAPayer) return FraisStatus.OVERPAID;
        if(totalPaye == montantAPayer) return FraisStatus.PAID;
        if(temps.isAfter(deadline)) return FraisStatus.LATE;

        return FraisStatus.IN_PROGRESS;
    }

    public double getTotalPaye(){
        return  payments.stream().mapToDouble(Payment::getMontant).sum();
    }

}

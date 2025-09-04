package school.hei.model;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    public static List<Frais> getLateFees(List<Frais> frais, Instant t) {
        return frais.stream()
                    .filter(f-> f.statusFrais(t) == FraisStatus.LATE)
                    .collect(Collectors.toList());
    }

    public static double getTotalMissingFees(List<Frais> frais, Instant t) {
        return frais.stream()
                .filter(f -> f.statusFrais(t) == FraisStatus.LATE)
                .mapToDouble(f -> f.getMontantAPayer() - f.getTotalPaye())
                .sum();
    }

    public static double getTotalPaidByStudent(Etudiant etudiant, List<Frais> frais, Instant t) {
        return frais.stream()
                .filter(f -> f.getEtudiantConcerne().equals(etudiant))
                .mapToDouble(Frais::getTotalPaye)
                .sum();
    }
}

package school.hei.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Groupe {
    private final String id;
    private final String nom;
    private List<Groupe> GroupeHistorique = new ArrayList<>();
    public Groupe(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void ajouterHistoriqueGroupe(Groupe groupe){
        GroupeHistorique.add(groupe);
    }
}

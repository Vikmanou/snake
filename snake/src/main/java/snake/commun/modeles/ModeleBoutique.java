package snake.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import snake.commun.valeurs.Fruit;
import snake.frontal.vues.VueBoutique;

public class ModeleBoutique implements Model, WatchJson, WriteObjectGraph {
    // private List<Fruit> fruits = new ArrayList<>();
    private int argent = 10;

    public void setArgent(VueBoutique vueBoutique) {
        vueBoutique.setArgent(this.argent);
    }

    public void ajouterArgent(int montant) {
        this.argent += montant;
    }
}

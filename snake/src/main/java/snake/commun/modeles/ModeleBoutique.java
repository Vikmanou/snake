package snake.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import snake.commun.valeurs.Fruit;

public class ModeleBoutique implements Model, WatchJson, WriteObjectGraph {
    private List<Fruit> fruits = new ArrayList<>();
}

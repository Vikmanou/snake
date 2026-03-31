package snake.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import snake.commun.valeurs.Fruit;
import snake.frontal.vues.VueBoutique;

public class ModeleBoutique implements Model, WatchJson, WriteObjectGraph {
	private List<Fruit> fruits = new ArrayList<>();

	public Fruit getFruit(String nom) {
		for (Fruit fruit : fruits) {
			if (fruit.getNom().equals(nom)) {
				return fruit;
			}
		}
		return null;
	}

	public int getPrix(String nom) {
		Fruit fruit = getFruit(nom);
		return fruit != null ? fruit.getPrix() : 0;
	}

	public void afficherFruits(VueBoutique vueBoutique) {
		vueBoutique.viderFruits();

		fruits.sort((f1, f2) -> Integer.compare(f1.getOrdreDansBoutique(), f2.getOrdreDansBoutique()));

		for (Fruit fruit : fruits) {
			if (fruit.getMontrerDansLaBoutique()) {
				vueBoutique.ajouterItemBoutique(fruit.getNom(), fruit.getPrix());
			}
		}
	}

	public void initialiserFruits() {
		fruits.clear();
		fruits.add(new Fruit("Pomme", 10, 5, false));
		fruits.add(new Fruit("Banane", 15, 2, true));
		fruits.add(new Fruit("Cerise", 20, 3, true));
		fruits.add(new Fruit("Raisin", 25, 4, true));
		fruits.add(new Fruit("Mangue", 30, 1, true));
	}

}

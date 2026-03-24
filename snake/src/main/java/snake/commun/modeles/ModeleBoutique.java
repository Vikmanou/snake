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
	private int argent = 10;

	public void setArgent(VueBoutique vueBoutique) {
		vueBoutique.setArgent(this.argent);
	}

	public void ajouterArgent(int montant) {
		this.argent += montant;
	}

	public void afficherFruits(VueBoutique vueBoutique) {
		vueBoutique.viderFruits();
		for (Fruit fruit : fruits) {
			if (fruit.getMontrerDansLaBoutique()) {
				vueBoutique.ajouterItemBoutique(fruit.getNom(), fruit.getPrix());
			}
		}
	}

	public void initialiserFruits() {
		fruits.clear();
		fruits.add(new Fruit("Pomme", 10, 1, true));
		fruits.add(new Fruit("Banane", 15, 2, true));
		fruits.add(new Fruit("Cerise", 20, 3, true));
		fruits.add(new Fruit("Raisin", 25, 4, true));
		fruits.add(new Fruit("Mangue", 30, 5, true));
	}

	public void acheterFruit(String nom) {
		for (Fruit fruit : fruits) {
			if (fruit.getNom().equals(nom)) {
				argent -= fruit.getPrix();
				return;
			}
		}
	}
}

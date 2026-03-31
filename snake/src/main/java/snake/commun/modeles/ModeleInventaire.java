package snake.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import snake.commun.valeurs.Fruit;
import snake.frontal.vues.VueBoutique;

public class ModeleInventaire implements Model, WatchJson, WriteObjectGraph {

	private int argent = 10;
	private List<Fruit> fruitsAchetes = new ArrayList<>();

	public int getArgent() {
		return argent;
	}

	public List<Fruit> getFruitsAchetes() {
		return fruitsAchetes;
	}

	public void ajouterArgent(int montant) {
		this.argent += montant;
	}

	public void afficherArgent(VueBoutique vueBoutique) {
		vueBoutique.setArgent(this.argent);
	}

	public void acheterFruit(Fruit fruit) {
		if (fruit == null) {
			return;
		}

		boolean dejaAchete = estFruitAchete(fruit.getNom());

		if (!dejaAchete) {
			fruitsAchetes.add(fruit);
		}
	}

	public boolean estFruitAchete(String nomFruit) {
		for (Fruit fruit : fruitsAchetes) {
			if (fruit.getNom().equals(nomFruit)) {
				return true;
			}
		}
		return false;
	}
}

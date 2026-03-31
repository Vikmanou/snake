package snake.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import snake.frontal.vues.VueBoutique;

public class ModeleInventaire implements Model, WatchJson, WriteObjectGraph {

	private int argent = 10;
	private List<String> fruitsAchetes = new ArrayList<>();

	public int getArgent() {
		return argent;
	}

	public List<String> getFruitsAchetes() {
		return fruitsAchetes;
	}

	public void ajouterArgent(int montant) {
		this.argent += montant;
	}

	public void afficherArgent(VueBoutique vueBoutique) {
		vueBoutique.setArgent(this.argent);
	}

	public void acheterFruit(String nom) {
		if (!fruitsAchetes.contains(nom)) {
			fruitsAchetes.add(nom);
		}
	}
}

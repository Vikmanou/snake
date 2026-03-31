package snake.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import snake.commun.messages.MsgAcheterFruit;
import snake.commun.modeles.ModeleBoutique;
import snake.commun.modeles.ModeleInventaire;

public class GererFruits {

	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("GererFruits")
				.waitsFor(model(ModeleBoutique.class))
				.waitsFor(model(ModeleInventaire.class))
				.contains(subTasks -> {
					tacheInitialiserFruits(subTasks);
					tacheInitialiserInventaire(subTasks);
					tacheAcheterFruit(subTasks);
				});
	}

	private static void tacheInitialiserFruits(BackendTasks subTasks) {
		subTasks.task("tacheInitialiserFruits")
				.waitsFor(model(ModeleBoutique.class))
				.executes(inputs -> {
					ModeleBoutique modeleBoutique = inputs.get(model(ModeleBoutique.class));

					modeleBoutique.initialiserFruits();
				});
	}

	private static void tacheInitialiserInventaire(BackendTasks subTasks) {
		subTasks.task("tacheInitialiserInventaire")
				.waitsFor(model(ModeleInventaire.class))
				.executes(inputs -> {
					ModeleInventaire modeleInventaire = inputs.get(model(ModeleInventaire.class));

					modeleInventaire.initialiserInventaire();
				});
	}

	private static void tacheAcheterFruit(BackendTasks subTasks) {
		subTasks.task("tacheAcheterFruit")
				.waitsFor(model(ModeleBoutique.class))
				.waitsFor(model(ModeleInventaire.class))
				.waitsFor(message(MsgAcheterFruit.class))
				.executes(inputs -> {
					MsgAcheterFruit msgAcheterFruit = inputs.get(message(MsgAcheterFruit.class));
					ModeleBoutique modeleBoutique = inputs.get(model(ModeleBoutique.class));
					ModeleInventaire modeleInventaire = inputs.get(model(ModeleInventaire.class));

					msgAcheterFruit.acheterFruit(modeleBoutique, modeleInventaire);
				});
	}
}

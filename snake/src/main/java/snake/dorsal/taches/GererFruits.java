package snake.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import snake.commun.messages.MsgAcheterFruit;
import snake.commun.modeles.ModeleBoutique;

public class GererFruits {

	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("GererFruits")
				.waitsFor(model(ModeleBoutique.class))
				.contains(subTasks -> {
					tacheInitialiserFruits(subTasks);
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

	private static void tacheAcheterFruit(BackendTasks subTasks) {
		subTasks.task("tacheAcheterFruit")
				.waitsFor(model(ModeleBoutique.class))
				.waitsFor(message(MsgAcheterFruit.class))
				.executes(inputs -> {
					MsgAcheterFruit msgAcheterFruit = inputs.get(message(MsgAcheterFruit.class));
					ModeleBoutique modeleBoutique = inputs.get(model(ModeleBoutique.class));

					msgAcheterFruit.acheterFruit(modeleBoutique);
				});
	}
}

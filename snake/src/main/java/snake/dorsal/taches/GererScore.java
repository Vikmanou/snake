package snake.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import snake.commun.messages.MsgSauvegarderScore;
import snake.commun.modeles.ModeleScore;

public class GererScore {

    public static void creerTaches(BackendTasks tasks) {
        tasks.taskGroup("GererScore")
                .waitsFor(model(ModeleScore.class))
                .contains(subTasks -> {
                    tacheSauvegarderScore(subTasks);
                });
    }

    private static void tacheSauvegarderScore(BackendTasks subTasks) {
        subTasks.task("tacheSauvegarderScore")
                .waitsFor(model(ModeleScore.class))
                .waitsFor(message(MsgSauvegarderScore.class))
                .executes(inputs -> {
                    MsgSauvegarderScore msgSauvegarderScore = inputs.get(message(MsgSauvegarderScore.class));
                    ModeleScore modeleScore = inputs.get(model(ModeleScore.class));

                    msgSauvegarderScore.sauvegarderScore(modeleScore);
                });
    }
}

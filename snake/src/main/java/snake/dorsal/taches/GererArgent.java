package snake.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import snake.commun.modeles.ModeleBoutique;

public class GererArgent {
    public static void creerTaches(BackendTasks tasks) {
        tasks.taskGroup("GererArgent")
                .waitsFor(model(ModeleBoutique.class))
                .contains(subTasks -> {
                    tacheAjouterArgent(subTasks);
                });
    }

    private static void tacheAjouterArgent(BackendTasks subTasks) {
        subTasks.task("tacheAjouterArgent")
                .waitsFor(model(ModeleBoutique.class))
                .waitsFor(message(snake.commun.messages.MsgAjouterArgent.class))
                .executes(inputs -> {
                    var msgAjouterArgent = inputs.get(message(snake.commun.messages.MsgAjouterArgent.class));
                    var modeleBoutique = inputs.get(model(ModeleBoutique.class));

                    msgAjouterArgent.ajouterArgent(modeleBoutique);
                });
    }
}

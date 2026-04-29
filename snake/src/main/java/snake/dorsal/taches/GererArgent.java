package snake.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import snake.commun.messages.MsgAjouterArgent;
import snake.commun.modeles.ModeleInventaire;

public class GererArgent {
    public static void creerTaches(BackendTasks tasks) {
        tasks.taskGroup("GererArgent")
                .waitsFor(model(ModeleInventaire.class))
                .contains(subTasks -> {
                    tacheAjouterArgent(subTasks);
                });
    }

    private static void tacheAjouterArgent(BackendTasks subTasks) {
        subTasks.task("tacheAjouterArgent")
                .waitsFor(model(ModeleInventaire.class))
                .waitsFor(message(MsgAjouterArgent.class))
                .executes(inputs -> {
                    MsgAjouterArgent msgAjouterArgent = inputs.get(message(MsgAjouterArgent.class));
                    ModeleInventaire modeleInventaire = inputs.get(model(ModeleInventaire.class));

                    msgAjouterArgent.ajouterArgent(modeleInventaire);
                });
    }
}

package snake.frontal.taches;

import snake.commun.modeles.ModeleBoutique;
import snake.frontal.vues.VueBoutique;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class AfficherItemsBoutique {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("AfficherItemsBoutique")
                .waitsFor("naviguerVersBoutique")
                .contains(subTasks -> {
                    afficherFruits(subTasks);
                });
    }

    public static void afficherFruits(FrontendTasks tasks) {
        tasks.task("afficherFruits")
                .waitsFor(modified(ModeleBoutique.class))
                .waitsFor(created(VueBoutique.class))
                .executes(inputs -> {
                    var modeleBoutique = inputs.get(modified(ModeleBoutique.class));
                    var vueBoutique = inputs.get(created(VueBoutique.class));

                    modeleBoutique.currentValue().afficherFruits(vueBoutique);
                });

    }
}

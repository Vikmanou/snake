package snake.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class AffichageBoutique {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("AffichageBoutique")
                .contains(subTasks -> {
                    afficherBoutique(subTasks);
                });
    }

    private static void afficherBoutique(FrontendTasks tasks) {
        tasks.task("afficherBoutique")
                .waitsFor(window())
                .executes(inputs -> {
                    var fenetreBoutique = inputs.get(window());
                    fenetreBoutique.show();
                });
    }
}

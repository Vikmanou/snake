package snake.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.frontal.vues.VueBoutique;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class AffichagePage {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("AffichagePage")
                .waitsFor("CreerVues")
                .contains(subTasks -> {
                    installerVuePage(subTasks);
                    afficherPage(subTasks);
                });
    }

    private static void installerVuePage(FrontendTasks subTasks) {
        subTasks.task("installerVuePage")

                .waitsFor(window())

                .waitsFor(created(VueBoutique.class))

                .executes(inputs -> {

                    VueBoutique vuePage = inputs.get(created(VueBoutique.class));
                    ca.ntro.app.services.Window window = inputs.get(window());

                    window.installRootView(vuePage);
                });
    }

    private static void afficherPage(FrontendTasks tasks) {
        tasks.task("afficherPage")
                .waitsFor(window())
                .executes(inputs -> {
                    ca.ntro.app.services.Window fenetrePage = inputs.get(window());
                    fenetrePage.show();
                });
    }
}

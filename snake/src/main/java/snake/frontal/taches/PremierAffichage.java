package snake.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.frontal.evenements.EvtAfficherVueAccueil;
import snake.frontal.vues.*;
import ca.ntro.app.Ntro;
import ca.ntro.app.services.Window;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class PremierAffichage {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("PremierAffichage")
                .waitsFor("CreerVues")
                .contains(subTasks -> {
                    installerVueRacine(subTasks);
                    afficherFenetre(subTasks);
                    naviguerVersPremierVue(subTasks);
                });
    }

    private static void installerVueRacine(FrontendTasks subTasks) {
        subTasks.task("installerVueRacine")
                .waitsFor(window())
                .waitsFor(created(VueRacine.class))
                .executes(inputs -> {
                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    Window window = inputs.get(window());

                    window.installRootView(vueRacine);
                });
    }

    private static void afficherFenetre(FrontendTasks tasks) {
        tasks.task("afficherFenetre")
                .waitsFor(window())
                .executes(inputs -> {
                    Window fenetrePage = inputs.get(window());
                    fenetrePage.show();
                });
    }

    private static void naviguerVersPremierVue(FrontendTasks tasks) {
        tasks.task("naviguerVersPremierVue")
                .waitsFor(created(VueAccueil.class))
                .executes(inputs -> {
                    Ntro.newEvent(EvtAfficherVueAccueil.class).trigger();
                });
    }

}

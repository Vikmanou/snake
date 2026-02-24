package snake.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.frontal.evenements.*;
import snake.frontal.vues.*;

public class Navigation {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("Navigation")
                .waitsFor("PremierAffichage")
                .contains(subtasks -> {
                    afficherVueAccueil(subtasks);
                    afficherVueBoutique(subtasks);
                });
    }

    private static void afficherVueBoutique(FrontendTasks tasks) {
        tasks.task("naviguerVersBoutique")
                .waitsFor(event(EvtAfficherVueBoutique.class))
                .waitsFor(created(VueRacine.class))
                .waitsFor(created(VueBoutique.class))
                .executes(inputs -> {
                    EvtAfficherVueBoutique evtAfficherVueBoutique = inputs
                            .get(event(EvtAfficherVueBoutique.class));
                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    VueBoutique vueBoutique = inputs.get(created(VueBoutique.class));

                    evtAfficherVueBoutique.afficherVueBoutique(vueRacine, vueBoutique);
                });
    }

    private static void afficherVueAccueil(FrontendTasks tasks) {
        tasks.task("naviguerVersAccueil")
                .waitsFor(event(EvtAfficherVueAccueil.class))
                .waitsFor(created(VueRacine.class))
                .waitsFor(created(VueAccueil.class))
                .executes(inputs -> {
                    EvtAfficherVueAccueil evtAfficherVueAccueil = inputs
                            .get(event(EvtAfficherVueAccueil.class));
                    VueRacine vueRacine = inputs.get(created(VueRacine.class));
                    VueAccueil vueAccueil = inputs.get(created(VueAccueil.class));

                    evtAfficherVueAccueil.afficherVueAccueil(vueRacine, vueAccueil);
                });
    }
}

package snake.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.modified.Modified;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.commun.modeles.ModeleScore;
import snake.frontal.vues.VueAccueil;

public class AfficherMeilleurScore {

    public static void creerTaches(FrontendTasks tasks) {
        tasks.task("afficherMeilleurScore")
                .waitsFor(modified(ModeleScore.class))
                .waitsFor(created(VueAccueil.class))
                .executes(inputs -> {
                    Modified<ModeleScore> modeleScore = inputs.get(modified(ModeleScore.class));
                    VueAccueil vueAccueil = inputs.get(created(VueAccueil.class));

                    vueAccueil.setMeilleurScore(modeleScore.currentValue().getMeilleurScore());
                });
    }
}

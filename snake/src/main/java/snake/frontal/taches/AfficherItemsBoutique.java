package snake.frontal.taches;

import snake.commun.modeles.ModeleBoutique;
import snake.commun.modeles.ModeleInventaire;
import snake.frontal.vues.VueBoutique;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.app.modified.Modified;

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
                .waitsFor(modified(ModeleInventaire.class))
                .waitsFor(created(VueBoutique.class))
                .executes(inputs -> {
                    Modified<ModeleBoutique> modeleBoutique = inputs.get(modified(ModeleBoutique.class));
                    Modified<ModeleInventaire> modeleInventaire = inputs.get(modified(ModeleInventaire.class));
                    VueBoutique vueBoutique = inputs.get(created(VueBoutique.class));

                    modeleBoutique.currentValue().afficherFruits(vueBoutique, modeleInventaire.currentValue());
                });

    }
}

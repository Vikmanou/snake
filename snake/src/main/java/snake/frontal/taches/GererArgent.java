package snake.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.modified.Modified;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.commun.modeles.ModeleBoutique;
import snake.frontal.vues.VueBoutique;

public class GererArgent {
    public static void creerTaches(FrontendTasks tasks) {
        tasks.taskGroup("GererArgent")
                .waitsFor("naviguerVersBoutique")
                .contains(subTasks -> {
                    observerArgent(subTasks);
                });
    }

    private static void observerArgent(FrontendTasks subTasks) {
        subTasks.task("observerArgent")
                .waitsFor(modified(ModeleBoutique.class))
                .waitsFor(created(VueBoutique.class))
                .executes(inputs -> {
                    VueBoutique vueBoutique = inputs.get(created(VueBoutique.class));
                    Modified<ModeleBoutique> modeleBoutique = inputs.get(modified(ModeleBoutique.class));

                    modeleBoutique.currentValue().setArgent(vueBoutique);
                });
    }
}

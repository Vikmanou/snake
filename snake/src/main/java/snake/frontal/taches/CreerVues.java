package snake.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import javafx.stage.Window;
import snake.frontal.vues.VuePage;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class CreerVues {
    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("CreerVues")

                .waitsFor(viewLoaders())

                .contains(subTasks -> {

                    creerVuePage(subTasks);

                });
    }

    private static void creerVuePage(FrontendTasks subTasks) {

        subTasks.task(create(VuePage.class))

                .waitsFor(viewLoader(VuePage.class))

                .executesAndReturnsValue(inputs -> {

                    var viewLoader = inputs.get(viewLoader(VuePage.class));
                    VuePage vuePage = viewLoader.createView();

                    return vuePage;
                });
    }
}

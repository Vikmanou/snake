package snake.frontal;

import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.frontal.taches.AffichageBoutique;

public class FrontalSnake implements FrontendFx {

    @Override
    public void createTasks(FrontendTasks tasks) {
        AffichageBoutique.creerTaches(tasks);
    }

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerSessionClass(SessionRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {

    }

}

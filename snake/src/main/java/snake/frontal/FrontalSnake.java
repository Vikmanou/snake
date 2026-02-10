package snake.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.frontal.taches.AffichagePage;
import snake.frontal.taches.CreerVues;
import snake.frontal.vues.VuePage;

public class FrontalSnake implements FrontendFx {

    @Override
    public void createTasks(FrontendTasks tasks) {
        CreerVues.creerTaches(tasks);
        AffichagePage.creerTaches(tasks);
    }

    @Override
    public void registerEvents(EventRegistrar registrar) {

    }

    @Override
    public void registerSessionClass(SessionRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerDefaultLocale(Ntro.buildLocale("fr"));
        registrar.registerTranslations(Ntro.buildLocale("fr"), "/traductions/fr.properties");
        registrar.registerTranslations(Ntro.buildLocale("en"), "/traductions/en.properties");

        registrar.registerView(VuePage.class, "/vues/page.fxml");

        registrar.registerStylesheet("/style/prod.css");
    }

}

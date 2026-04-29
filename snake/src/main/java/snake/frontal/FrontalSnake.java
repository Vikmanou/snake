package snake.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.frontal.taches.*;
import snake.frontal.vues.*;
import snake.frontal.evenements.*;
import snake.frontal.fragments.*;

public class FrontalSnake implements FrontendFx {

    @Override
    public void createTasks(FrontendTasks tasks) {
        CreerVues.creerTaches(tasks);
        PremierAffichage.creerTaches(tasks);
        Navigation.creerTaches(tasks);
        GererArgent.creerTaches(tasks);
        AfficherItemsBoutique.creerTaches(tasks);
        TacheJeu.creerTaches(tasks);
        AfficherMeilleurScore.creerTaches(tasks);
    }

    @Override
    public void registerEvents(EventRegistrar registrar) {
        registrar.registerEvent(EvtAfficherVueAccueil.class);
        registrar.registerEvent(EvtAfficherVueBoutique.class);
        registrar.registerEvent(EvtAfficherVueJeu.class);
        registrar.registerEvent(EvtChangerDirection.class);
    }

    @Override
    public void registerSessionClass(SessionRegistrar registrar) {

    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerDefaultLocale(Ntro.buildLocale("fr"));
        registrar.registerTranslations(Ntro.buildLocale("fr"), "/traductions/fr.properties");
        registrar.registerTranslations(Ntro.buildLocale("en"), "/traductions/en.properties");

        registrar.registerView(VueRacine.class, "/vues/racine.fxml");

        registrar.registerView(VueBoutique.class, "/vues/boutique.fxml");
        registrar.registerFragment(ItemBoutique.class, "/fragments/item_boutique.fxml");

        registrar.registerView(VueAccueil.class, "/vues/accueil.fxml");
        registrar.registerView(VueJeu.class, "/vues/jeu.fxml");

        registrar.registerStylesheet("/style/prod.css");
    }
}

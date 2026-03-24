package snake.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import javafx.stage.Window;
import snake.frontal.vues.*;
import snake.frontal.fragments.*;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;

public class CreerVues {
    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("CreerVues")

                .waitsFor(viewLoaders())

                .contains(subTasks -> {

                    creerVueBoutique(subTasks);
                    creerVueAccueil(subTasks);
                    creerVueJeu(subTasks);
                    creerVueRacine(subTasks);

                });
    }

    private static void creerVueBoutique(FrontendTasks subTasks) {
        subTasks.task(create(VueBoutique.class))
                .waitsFor(viewLoader(VueBoutique.class))
                .waitsFor(viewLoader(ItemBoutique.class))
                .executesAndReturnsValue(inputs -> {
                    ViewLoader<VueBoutique> viewLoader = inputs.get(viewLoader(VueBoutique.class));
                    ViewLoader<ItemBoutique> itemLoader = inputs.get(viewLoader(ItemBoutique.class));

                    VueBoutique vueBoutique = viewLoader.createView();
                    vueBoutique.setItemBoutiqueViewLoader(itemLoader);

                    return vueBoutique;
                });
    }

    private static void creerVueAccueil(FrontendTasks subTasks) {
        subTasks.task(create(VueAccueil.class))
                .waitsFor(viewLoader(VueAccueil.class))
                .executesAndReturnsValue(inputs -> {
                    ViewLoader<VueAccueil> viewLoader = inputs.get(viewLoader(VueAccueil.class));
                    VueAccueil vueAccueil = viewLoader.createView();

                    return vueAccueil;
                });
    }

    private static void creerVueJeu(FrontendTasks subTasks) {
        subTasks.task(create(VueJeu.class))
                .waitsFor(viewLoader(VueJeu.class))
                .executesAndReturnsValue(inputs -> {
                    ViewLoader<VueJeu> viewLoader = inputs.get(viewLoader(VueJeu.class));
                    VueJeu vueJeu = viewLoader.createView();

                    return vueJeu;
                });
    }

    private static void creerVueRacine(FrontendTasks subTasks) {
        subTasks.task(create(VueRacine.class))
                .waitsFor(viewLoader(VueRacine.class))
                .executesAndReturnsValue(inputs -> {
                    ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
                    VueRacine vueRacine = viewLoader.createView();

                    return vueRacine;
                });
    }
}

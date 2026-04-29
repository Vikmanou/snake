package snake.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import snake.commun.modeles.ModeleInventaire;
import snake.frontal.donnees.DonneesVueJeu;
import snake.frontal.evenements.EvtChangerDirection;
import snake.frontal.vues.VueJeu;

public class TacheJeu {

    public static void creerTaches(FrontendTasks tasks) {

        creerDonneesVueJeu(tasks);

        tasks.taskGroup("TacheJeu")
                .waitsFor(created(DonneesVueJeu.class))
                .contains(subTasks -> {
                    boucleJeu(subTasks);
                    changerDirection(subTasks);
                });
    }

    private static void creerDonneesVueJeu(FrontendTasks tasks) {
        tasks.task(create(DonneesVueJeu.class))
                .waitsFor("naviguerVersJeu")
                .executesAndReturnsValue(inputs -> {
                    return new DonneesVueJeu(null);
                });

        tasks.task("mettreAJourInventaireDansJeu")
                .waitsFor(created(DonneesVueJeu.class))
                .waitsFor(modified(ModeleInventaire.class))
                .executes(inputs -> {
                    var donneesVueJeu = inputs.get(created(DonneesVueJeu.class));
                    var modeleInventaire = inputs.get(modified(ModeleInventaire.class));
                    donneesVueJeu.setModeleInventaire(modeleInventaire.currentValue());
                });
    }

    private static void boucleJeu(FrontendTasks subTasks) {
        subTasks.task("boucleJeu")
                .waitsFor("naviguerVersJeu")
                .waitsFor(clock().nextTick())
                .waitsFor(created(DonneesVueJeu.class))
                .waitsFor(created(VueJeu.class))
                .executes(inputs -> {
                    var vueJeu = inputs.get(created(VueJeu.class));
                    var donneesVueJeu = inputs.get(created(DonneesVueJeu.class));
                    var tick = inputs.get(clock().nextTick());

                    donneesVueJeu.onTimePasses(tick.elapsedTime());
                    donneesVueJeu.dessiner(vueJeu);
                });
    }

    private static void changerDirection(FrontendTasks subTasks) {
        subTasks.task("changerDirection")
                .waitsFor("naviguerVersJeu")
                .waitsFor(created(DonneesVueJeu.class))
                .waitsFor(event(EvtChangerDirection.class))
                .executes(inputs -> {
                    var evt = inputs.get(event(EvtChangerDirection.class));
                    var donneesVueJeu = inputs.get(created(DonneesVueJeu.class));

                    evt.changerDirection(donneesVueJeu);
                });
    }
}

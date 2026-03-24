package snake.frontal.evenements;

import ca.ntro.app.events.Event;
import snake.frontal.vues.VueJeu;
import snake.frontal.vues.VueRacine;

public class EvtAfficherVueJeu extends Event {
    public EvtAfficherVueJeu afficherVueJeu(VueRacine vueRacine, VueJeu vueJeu) {
        vueRacine.afficherVue(vueJeu);
        return this;
    }
}

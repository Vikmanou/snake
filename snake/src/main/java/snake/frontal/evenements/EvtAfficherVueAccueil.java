package snake.frontal.evenements;

import ca.ntro.app.events.Event;
import snake.frontal.vues.VueAccueil;
import snake.frontal.vues.VueRacine;

public class EvtAfficherVueAccueil extends Event {
    public EvtAfficherVueAccueil afficherVueAccueil(VueRacine vueRacine, VueAccueil vueAccueil) {
        vueRacine.afficherVue(vueAccueil);
        return this;
    }
}

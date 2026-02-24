package snake.frontal.evenements;

import ca.ntro.app.events.Event;
import snake.frontal.vues.VueBoutique;
import snake.frontal.vues.VueRacine;

public class EvtAfficherVueBoutique extends Event {
    public EvtAfficherVueBoutique afficherVueBoutique(VueRacine vueRacine, VueBoutique vueBoutique) {
        vueRacine.afficherVue(vueBoutique);
        return this;
    }
}

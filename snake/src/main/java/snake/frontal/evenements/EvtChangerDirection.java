package snake.frontal.evenements;

import ca.ntro.app.events.Event;
import snake.commun.enums.DirectionSnake;
import snake.frontal.donnees.DonneesVueJeu;

public class EvtChangerDirection extends Event {

    private DirectionSnake direction;

    public EvtChangerDirection setDirection(DirectionSnake direction) {
        this.direction = direction;
        return this;
    }

    public void changerDirection(DonneesVueJeu donneesVueJeu) {
        donneesVueJeu.changerDirection(direction);
    }
}

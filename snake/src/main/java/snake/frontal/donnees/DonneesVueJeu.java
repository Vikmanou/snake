package snake.frontal.donnees;

import ca.ntro.app.frontend.ViewData;
import snake.commun.enums.DirectionSnake;
import snake.commun.monde2d.MondeSnake2d;
import snake.frontal.vues.VueJeu;

public class DonneesVueJeu implements ViewData {

    private MondeSnake2d monde2d = new MondeSnake2d();

    public void onTimePasses(double secondsElapsed) {
        monde2d.onTimePasses(secondsElapsed);
    }

    public void dessiner(VueJeu vueJeu) {
        vueJeu.dessiner(monde2d);
    }

    public void changerDirection(DirectionSnake direction) {
        monde2d.changerDirection(direction);
    }
}

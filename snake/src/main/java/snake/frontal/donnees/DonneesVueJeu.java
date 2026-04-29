package snake.frontal.donnees;

import ca.ntro.app.frontend.ViewData;
import snake.commun.enums.DirectionSnake;
import snake.commun.modeles.ModeleInventaire;
import snake.commun.monde2d.MondeSnake2d;
import snake.frontal.vues.VueJeu;

public class DonneesVueJeu implements ViewData {

    private MondeSnake2d monde2d;
    private boolean premiereFrame = true;

    public DonneesVueJeu(ModeleInventaire modeleInventaire) {
        monde2d = new MondeSnake2d(modeleInventaire);
    }

    public void setModeleInventaire(ModeleInventaire modeleInventaire) {
        monde2d.setModeleInventaire(modeleInventaire);
    }

    public void onTimePasses(double secondsElapsed) {
        monde2d.onTimePasses(secondsElapsed);
    }

    public void dessiner(VueJeu vueJeu) {
        if (premiereFrame) {
            premiereFrame = false;
            vueJeu.reinitialiser();
        }

        vueJeu.dessiner(monde2d);

        if (monde2d.estMort()) {
            vueJeu.afficherEcranMort(monde2d.getScore());
        }
    }

    public void changerDirection(DirectionSnake direction) {
        monde2d.changerDirection(direction);
    }
}

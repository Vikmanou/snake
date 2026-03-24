package snake.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import snake.commun.enums.DirectionSnake;
import snake.commun.monde2d.MondeSnake2d;
import snake.frontal.controles.CanvasJeu;
import snake.frontal.evenements.EvtAfficherVueAccueil;
import snake.frontal.evenements.EvtChangerDirection;

public class VueJeu extends ViewFx {

    @FXML
    private Button boutonQuitter;

    @FXML
    private CanvasJeu canvas;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonQuitter);
        Ntro.assertNotNull(canvas);

        boutonQuitter.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherVueAccueil.class).trigger();
        });

        rootNode().setFocusTraversable(true);
        rootNode().requestFocus();

        rootNode().addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {
            if (evtFx.getCode().equals(KeyCode.UP)) {

                Ntro.newEvent(EvtChangerDirection.class)
                        .setDirection(DirectionSnake.HAUT)
                        .trigger();

            } else if (evtFx.getCode().equals(KeyCode.DOWN)) {

                Ntro.newEvent(EvtChangerDirection.class)
                        .setDirection(DirectionSnake.BAS)
                        .trigger();

            } else if (evtFx.getCode().equals(KeyCode.LEFT)) {

                Ntro.newEvent(EvtChangerDirection.class)
                        .setDirection(DirectionSnake.GAUCHE)
                        .trigger();

            } else if (evtFx.getCode().equals(KeyCode.RIGHT)) {

                Ntro.newEvent(EvtChangerDirection.class)
                        .setDirection(DirectionSnake.DROITE)
                        .trigger();
            }
        });
    }

    public void dessiner(MondeSnake2d monde2d) {
        monde2d.drawOn(canvas);
    }
}

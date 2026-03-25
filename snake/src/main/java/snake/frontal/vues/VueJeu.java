package snake.frontal.vues;

import java.util.Map;

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
import snake.frontal.utils.GestionnaireTouches;

public class VueJeu extends ViewFx {

    private GestionnaireTouches gestionnaireTouches = new GestionnaireTouches();

    private static final Map<KeyCode, DirectionSnake> DIRECTIONS_PAR_TOUCHE = Map.of(
            KeyCode.UP, DirectionSnake.HAUT,
            KeyCode.W, DirectionSnake.HAUT,
            KeyCode.DOWN, DirectionSnake.BAS,
            KeyCode.S, DirectionSnake.BAS,
            KeyCode.LEFT, DirectionSnake.GAUCHE,
            KeyCode.A, DirectionSnake.GAUCHE,
            KeyCode.RIGHT, DirectionSnake.DROITE,
            KeyCode.D, DirectionSnake.DROITE);

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

        installerEvenementsClavier();
    }

    private void installerEvenementsClavier() {
        rootNode().addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {
            gestionnaireTouches.activer(evtFx.getCode());
        });

        rootNode().addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {
            gestionnaireTouches.desactiver(evtFx.getCode());
        });

        gestionnaireTouches.reagirCombinaison(touches -> {
            KeyCode touche01 = null;

            if (touches.size() > 0) {
                touche01 = touches.get(0);
            }

            DirectionSnake direction = null;
            if (touche01 != null) {
                direction = DIRECTIONS_PAR_TOUCHE.get(touche01);
            }

            if (direction != null) {
                Ntro.newEvent(EvtChangerDirection.class)
                        .setDirection(direction)
                        .trigger();
            }
        });
    }

    public void dessiner(MondeSnake2d monde2d) {
        monde2d.drawOn(canvas);
    }
}

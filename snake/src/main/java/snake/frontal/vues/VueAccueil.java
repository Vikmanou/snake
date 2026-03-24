package snake.frontal.vues;

import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ca.ntro.app.Ntro;
import snake.frontal.evenements.EvtAfficherVueBoutique;
import snake.frontal.evenements.EvtAfficherVueJeu;

public class VueAccueil extends ViewFx {

    @FXML
    private Button boutonBoutique;

    @FXML
    private Button boutonJouer;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonBoutique);
        Ntro.assertNotNull(boutonJouer);

        boutonBoutique.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherVueBoutique.class).trigger();
        });

        boutonJouer.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherVueJeu.class).trigger();
        });
    }

}

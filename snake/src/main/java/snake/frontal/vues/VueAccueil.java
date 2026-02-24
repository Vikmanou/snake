package snake.frontal.vues;

import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ca.ntro.app.Ntro;
import snake.frontal.evenements.EvtAfficherVueBoutique;

public class VueAccueil extends ViewFx {

    @FXML
    private Button boutonBoutique;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonBoutique);

        boutonBoutique.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherVueBoutique.class).trigger();
        });
    }

}

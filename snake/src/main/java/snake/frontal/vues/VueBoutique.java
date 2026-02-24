package snake.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import snake.frontal.evenements.EvtAfficherVueAccueil;

public class VueBoutique extends ViewFx {

    @FXML
    private Button boutonRetourMenu;

    @FXML
    private Label labelArgent;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonRetourMenu);
        Ntro.assertNotNull(labelArgent);

        boutonRetourMenu.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherVueAccueil.class).trigger();
        });
    }

    public void setArgent(int argent) {
        labelArgent.setText("$" + argent);
    }
}

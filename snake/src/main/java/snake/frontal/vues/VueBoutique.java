package snake.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import snake.commun.messages.MsgAjouterArgent;
import snake.frontal.evenements.EvtAfficherVueAccueil;

public class VueBoutique extends ViewFx {

    @FXML
    private Button boutonRetourMenu;

    @FXML
    private Button boutonAcheter;

    @FXML
    private Label labelArgent;

    @Override
    public void initialize() {
        Ntro.assertNotNull(boutonRetourMenu);
        Ntro.assertNotNull(labelArgent);

        boutonRetourMenu.setOnAction(evtFx -> {
            Ntro.newEvent(EvtAfficherVueAccueil.class).trigger();
        });

        boutonAcheter.setOnAction(evtFx -> {
            Ntro.newMessage(MsgAjouterArgent.class)
                    .setMontantAleatoire()
                    .send();
        });
    }

    public void setArgent(int argent) {
        labelArgent.setText("$" + argent);
    }
}

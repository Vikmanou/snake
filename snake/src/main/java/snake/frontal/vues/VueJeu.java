package snake.frontal.vues;

import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ca.ntro.app.Ntro;
import snake.frontal.evenements.EvtAfficherVueAccueil;

public class VueJeu extends ViewFx {
	@FXML
	private Button boutonQuitter;

	@Override
	public void initialize() {
		Ntro.assertNotNull(boutonQuitter);

		boutonQuitter.setOnAction(evtFx -> {
			Ntro.newEvent(EvtAfficherVueAccueil.class).trigger();
		});
	}

}

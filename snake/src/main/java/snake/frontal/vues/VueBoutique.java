package snake.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import snake.frontal.evenements.EvtAfficherVueAccueil;
import ca.ntro.app.frontend.ViewLoader;
import snake.frontal.fragments.ItemBoutique;
import java.text.NumberFormat;
import java.util.Locale;

public class VueBoutique extends ViewFx {

	@FXML
	private Button boutonRetourMenu;

	@FXML
	private Label labelArgent;

	@FXML
	private HBox conteneurFruits;

	private ViewLoader<ItemBoutique> itemBoutiqueLoader;

	@Override
	public void initialize() {
		Ntro.assertNotNull(boutonRetourMenu);
		Ntro.assertNotNull(labelArgent);
		Ntro.assertNotNull(conteneurFruits);

		boutonRetourMenu.setOnAction(evtFx -> {
			Ntro.newEvent(EvtAfficherVueAccueil.class).trigger();
		});
	}

	public void setItemBoutiqueViewLoader(ViewLoader<ItemBoutique> loader) {
		this.itemBoutiqueLoader = loader;
	}

	public void setArgent(int argent) {
		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
		labelArgent.setText("$" + format.format(argent));
	}

	public void viderFruits() {
		conteneurFruits.getChildren().clear();
	}

	public void ajouterItemBoutique(String nomItem, int prix, boolean achete) {
		if (itemBoutiqueLoader != null) {
			ItemBoutique item = itemBoutiqueLoader.createView();
			item.setNomFruit(nomItem);
			item.setPrixFruit(prix);
			item.setAchetee(achete);

			conteneurFruits.getChildren().add(item.rootNode());
		}
	}
}

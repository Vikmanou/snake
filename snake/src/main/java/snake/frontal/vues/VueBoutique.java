package snake.frontal.vues;

import javax.swing.text.View;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import snake.commun.messages.MsgAjouterArgent;
import snake.frontal.evenements.EvtAfficherVueAccueil;
import ca.ntro.app.frontend.ViewLoader;
import snake.frontal.fragments.ItemBoutique;

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

        /*
         * boutonAcheter.setOnAction(evtFx -> {
         * Ntro.newMessage(MsgAjouterArgent.class)
         * .setMontantAleatoire()
         * .send();
         * });
         */
    }

    public void setItemBoutiqueViewLoader(ViewLoader<ItemBoutique> loader) {
        this.itemBoutiqueLoader = loader;
    }

    public void setArgent(int argent) {
        labelArgent.setText("$" + argent);
    }

    public void ajouterItemBoutique(String nomItem, int prix) {
        if (itemBoutiqueLoader != null) {
            ItemBoutique item = itemBoutiqueLoader.createView();
            item.setNomFruit(nomItem);
            item.setPrixFruit(prix);

            conteneurFruits.getChildren().add(item.rootNode());
        }
    }
}

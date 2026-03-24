package snake.frontal.fragments;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFragmentFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import snake.commun.messages.MsgAcheterFruit;

public class ItemBoutique extends ViewFragmentFx {
    @FXML
    private Label nomFruit;

    @FXML
    private Label prixFruit;

    @FXML
    private Button boutonAcheter;

    private String nom;

    @Override
    public void initialize() {
        Ntro.assertNotNull(nomFruit);
        Ntro.assertNotNull(prixFruit);
        Ntro.assertNotNull(boutonAcheter);

        boutonAcheter.setOnAction(evtFx -> {
            Ntro.newMessage(MsgAcheterFruit.class)
                    .setNomFruit(nom)
                    .send();
        });
    }

    public void setNomFruit(String nom) {
        this.nom = nom;
        nomFruit.setText(nom);
    }

    public void setPrixFruit(int prix) {
        prixFruit.setText(prix + "$");
    }
}

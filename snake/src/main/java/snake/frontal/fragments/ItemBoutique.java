package snake.frontal.fragments;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFragmentFx;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemBoutique extends ViewFragmentFx {
    @FXML
    private Label nomFruit;

    @FXML
    private Label prixFruit;

    @Override
    public void initialize() {
        Ntro.assertNotNull(nomFruit);
        Ntro.assertNotNull(prixFruit);
    }

    public void setNomFruit(String nom) {
        nomFruit.setText(nom);
    }

    public void setPrixFruit(int prix) {
        prixFruit.setText(String.valueOf(prix));
    }
}

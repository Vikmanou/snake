package snake.frontal.vues;

import ca.ntro.app.frontend.ViewFx;

public class VueRacine extends ViewFx {
    @Override
    public void initialize() {

    }

    public void afficherVue(ViewFx vue) {
        rootNode().getChildren().clear();
        rootNode().getChildren().add(vue.rootNode());
    }
}

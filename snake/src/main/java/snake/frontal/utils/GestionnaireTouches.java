package snake.frontal.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.input.KeyCode;

public class GestionnaireTouches {
    private Consumer<List<KeyCode>> capteurCombinaisons;
    private List<KeyCode> touchesActives = new ArrayList<>();

    public void activer(KeyCode code) {
        if (!touchesActives.contains(code)) {
            touchesActives.add(0, code);

            appelerCapteur();
        }
    }

    private void appelerCapteur() {
        if (capteurCombinaisons != null) {
            capteurCombinaisons.accept(touchesActives);
        }
    }

    public void desactiver(KeyCode code) {
        boolean removed = touchesActives.remove(code);

        if (removed) {
            capteurCombinaisons.accept(touchesActives);
        }
    }

    public void reagirCombinaison(Consumer<List<KeyCode>> capteurCombinaisons) {
        this.capteurCombinaisons = capteurCombinaisons;
    }
}

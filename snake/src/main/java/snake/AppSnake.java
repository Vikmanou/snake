package snake;

import ca.ntro.app.NtroAppFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import snake.frontal.FrontalSnake;

public class AppSnake implements NtroAppFx {

    public static void main(String[] args) {
        NtroAppFx.launch(args);
    }

    @Override
    public void registerModels(ModelRegistrar registrar) {

    }

    @Override
    public void registerMessages(MessageRegistrar registrar) {

    }

    @Override
    public void registerFrontend(FrontendRegistrarFx registrar) {
        registrar.registerFrontend(FrontalSnake.class);
    }

    @Override
    public void registerBackend(BackendRegistrar registrar) {

    }

}

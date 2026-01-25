package snake;

import ca.ntro.app.NtroAppFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

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

    }

    @Override
    public void registerBackend(BackendRegistrar registrar) {

    }

}

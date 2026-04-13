package snake;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import snake.frontal.FrontalSnake;
import snake.dorsal.DorsalDistantSnake;
import snake.commun.DeclarationsSnake;

public class ClientSnake implements NtroClientFx {
    public static void main(String[] args) {
        NtroClientFx.launch(args);
    }

    @Override
    public void registerModels(ModelRegistrar registrar) {
        DeclarationsSnake.declarerModeles(registrar);
    }

    @Override
    public void registerMessages(MessageRegistrar registrar) {
        DeclarationsSnake.declarerMessages(registrar);
    }

    @Override
    public void registerFrontend(FrontendRegistrarFx registrar) {
        registrar.registerFrontend(FrontalSnake.class);
    }

    @Override
    public void registerBackend(BackendRegistrar registrar) {
        registrar.registerBackend(DorsalDistantSnake.class);
    }
}

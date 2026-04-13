package snake;

import ca.ntro.app.NtroServerFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.common.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import snake.dorsal.DorsalDepart;
import snake.commun.DeclarationsSnake;

public class ServeurSnake implements NtroServerFx {
    public static void main(String[] args) {
        NtroServerFx.launch(args);
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
    public void registerBackend(BackendRegistrar registrar) {
        registrar.registerBackend(DorsalDepart.class);
    }

    @Override
    public void registerServer(ServerRegistrar registrar) {
        DeclarationsSnake.declarerServeur(registrar);
    }
}

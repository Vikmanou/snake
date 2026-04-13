package snake.dorsal;

import ca.ntro.app.backend.RemoteBackendNtro;
import ca.ntro.app.common.ServerRegistrar;
import snake.commun.DeclarationsSnake;

public class DorsalDistantSnake extends RemoteBackendNtro {
    @Override
    public void registerServer(ServerRegistrar registrar) {
        DeclarationsSnake.declarerServeur(registrar);
    }
}

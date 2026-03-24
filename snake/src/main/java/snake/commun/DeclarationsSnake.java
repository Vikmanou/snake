package snake.commun;

import ca.ntro.app.common.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import snake.commun.messages.*;
import snake.commun.modeles.*;
import snake.commun.valeurs.*;

public class DeclarationsSnake {
    public static void declarerModeles(ModelRegistrar registrar) {
        registrar.registerModel(ModeleBoutique.class);
        registrar.registerValue(Fruit.class);
    }

    public static void declarerMessages(MessageRegistrar registrar) {
        registrar.registerMessage(MsgAjouterArgent.class);
        registrar.registerMessage(MsgAcheterFruit.class);
    }

    public static void declarerServeur(ServerRegistrar registrar) {
        registrar.registerName("localhost");
        registrar.registerPort(8888);
    }
}

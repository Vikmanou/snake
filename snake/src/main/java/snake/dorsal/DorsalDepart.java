package snake.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import snake.dorsal.taches.*;

public class DorsalDepart extends LocalBackendNtro {

    @Override
    public void createTasks(BackendTasks tasks) {
        GererArgent.creerTaches(tasks);
    }

}

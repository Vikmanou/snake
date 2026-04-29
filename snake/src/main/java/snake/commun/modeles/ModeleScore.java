package snake.commun.modeles;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;

public class ModeleScore implements Model, WatchJson, WriteObjectGraph {

    private int meilleurScore = 0;

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void mettreAJourScore(int score) {
        if (score > meilleurScore) {
            meilleurScore = score;
        }
    }
}

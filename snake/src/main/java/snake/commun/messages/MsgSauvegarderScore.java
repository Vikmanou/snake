package snake.commun.messages;

import ca.ntro.app.messages.Message;
import snake.commun.modeles.ModeleScore;

public class MsgSauvegarderScore extends Message<MsgSauvegarderScore> {

    private int score;

    public MsgSauvegarderScore setScore(int score) {
        this.score = score;
        return this;
    }

    public void sauvegarderScore(ModeleScore modeleScore) {
        modeleScore.mettreAJourScore(score);
    }
}

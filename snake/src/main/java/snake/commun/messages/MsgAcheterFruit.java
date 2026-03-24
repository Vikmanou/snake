package snake.commun.messages;

import ca.ntro.app.messages.Message;
import snake.commun.modeles.ModeleBoutique;

public class MsgAcheterFruit extends Message<MsgAcheterFruit> {

    private String nomFruit;

    public String getNomFruit() {
        return nomFruit;
    }

    public MsgAcheterFruit setNomFruit(String nomFruit) {
        this.nomFruit = nomFruit;
        return this;
    }

    public void acheterFruit(ModeleBoutique modeleBoutique) {
        modeleBoutique.acheterFruit(nomFruit);
    }
}

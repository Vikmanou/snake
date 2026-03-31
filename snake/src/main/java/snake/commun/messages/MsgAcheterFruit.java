package snake.commun.messages;

import ca.ntro.app.messages.Message;
import snake.commun.modeles.ModeleBoutique;
import snake.commun.modeles.ModeleInventaire;

public class MsgAcheterFruit extends Message<MsgAcheterFruit> {

    private String nomFruit;

    public String getNomFruit() {
        return nomFruit;
    }

    public MsgAcheterFruit setNomFruit(String nomFruit) {
        this.nomFruit = nomFruit;
        return this;
    }

    public void acheterFruit(ModeleBoutique modeleBoutique, ModeleInventaire modeleInventaire) {
        int prix = modeleBoutique.getPrix(nomFruit);
        modeleInventaire.ajouterArgent(-prix);
        modeleInventaire.acheterFruit(nomFruit);
    }
}

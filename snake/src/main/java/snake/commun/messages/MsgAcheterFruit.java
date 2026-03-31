package snake.commun.messages;

import ca.ntro.app.messages.Message;
import snake.commun.modeles.ModeleBoutique;
import snake.commun.modeles.ModeleInventaire;
import snake.commun.valeurs.Fruit;

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
        Fruit fruit = modeleBoutique.getFruit(nomFruit);

        if (fruit != null) {
            modeleInventaire.ajouterArgent(-fruit.getPrix());
            modeleInventaire.acheterFruit(fruit);
        }
    }
}

package snake.commun.messages;

import ca.ntro.app.Ntro;
import ca.ntro.app.messages.Message;
import snake.commun.modeles.ModeleBoutique;

public class MsgAjouterArgent extends Message<MsgAjouterArgent> {
    private int montant;

    public void ajouterArgent(ModeleBoutique modeleBoutique) {
        modeleBoutique.ajouterArgent(montant);
    }

    public MsgAjouterArgent setMontantAleatoire() {
        this.montant = Ntro.random().nextInt(100);
        return this;
    }
}

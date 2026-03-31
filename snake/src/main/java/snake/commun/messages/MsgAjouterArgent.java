package snake.commun.messages;

import ca.ntro.app.Ntro;
import ca.ntro.app.messages.Message;
import snake.commun.modeles.ModeleInventaire;

public class MsgAjouterArgent extends Message<MsgAjouterArgent> {
    private int montant;

    public void ajouterArgent(ModeleInventaire modeleInventaire) {
        modeleInventaire.ajouterArgent(montant);
    }

    public MsgAjouterArgent setMontant(int montant) {
        this.montant = montant;
        return this;
    }

    public MsgAjouterArgent setMontantAleatoire() {
        this.montant = Ntro.random().nextInt(100);
        return this;
    }
}

package snake.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Fruit implements ModelValue {
    private String nom;
    private int prix;
    private int ordreDansBoutique;
    private String image;
    private boolean montrerDansLaBoutique;

    @Override
    public String toString() {
        return nom;
    }
}

package snake.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Fruit implements ModelValue {
    private String nom;
    private int prix;
    private int ordreDansBoutique;
    private boolean montrerDansLaBoutique;
    private int bonusTailleSerpent;

    public Fruit(String nom, int prix, int ordreDansBoutique, boolean montrerDansLaBoutique, int bonusTailleSerpent) {
        this.nom = nom;
        this.prix = prix;
        this.ordreDansBoutique = ordreDansBoutique;
        this.montrerDansLaBoutique = montrerDansLaBoutique;
        this.bonusTailleSerpent = bonusTailleSerpent;
    }

    public String getImage() {
        return this.nom.toLowerCase();
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public int getOrdreDansBoutique() {
        return ordreDansBoutique;
    }

    public boolean getMontrerDansLaBoutique() {
        return montrerDansLaBoutique;
    }

    public int getBonusTailleSerpent() {
        return bonusTailleSerpent;
    }
}

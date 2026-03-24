package snake.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Fruit implements ModelValue {
    private String nom;
    private int prix;
    private int ordreDansBoutique;
    private boolean montrerDansLaBoutique;

    public Fruit() {
    }

    public Fruit(String nom, int prix, int ordreDansBoutique, boolean montrerDansLaBoutique) {
        this.nom = nom;
        this.prix = prix;
        this.ordreDansBoutique = ordreDansBoutique;
        this.montrerDansLaBoutique = montrerDansLaBoutique;
    }

    @Override
    public String toString() {
        return nom;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public boolean getMontrerDansLaBoutique() {
        return montrerDansLaBoutique;
    }
}

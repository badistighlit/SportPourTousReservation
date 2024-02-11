package domain;

public class Navette implements PrestationSupplementaire {
    private int id;
    private String nom;
    private String type;
    private double prix;

    public Navette(String  nom, String type, double prix){
        this.nom=nom;
        this.type=type;
        this.prix=prix;
    }


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double getPrix() {
        return this.prix;
    }

    // Implémentation des méthodes de l'interface
}
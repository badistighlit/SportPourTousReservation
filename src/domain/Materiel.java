package domain;

public class Materiel {
    private int id;
    private String nom;
    private String type;
    private double caution;

    // Constructeur
    public Materiel(int id, String nom, String type, double caution) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.caution = caution;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCaution() {
        return caution;
    }

    public void setCaution(double caution) {
        this.caution = caution;
    }


}

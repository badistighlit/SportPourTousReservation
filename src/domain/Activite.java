package domain;

public class Activite {
    private String id;
    private String nom;
    private String description;
    public Activite (String nom, String description){
        this.nom = nom;
        this.description=description;
    }
    public String getNom (){return this.nom;}
    public String getDescription(){return this.description;}



    // Getters, setters et autres méthodes
}

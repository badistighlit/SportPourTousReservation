package domain;

public class Client {
    private String id;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String num;

    public Client(String id, String nom, String prenom, String adresseMail, String num) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.num = num;
    }
}

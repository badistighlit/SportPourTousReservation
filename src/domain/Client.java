package domain;

public class Client {
    final private int id;
    final private String nom;
    final private String prenom;
    final private String adresseMail;
    final private String num;

    public Client(int id, String nom, String prenom, String adresseMail, String num) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.num = num;
    }

    public String getNom (){return this.nom;}
    public String getPrenom (){return this.prenom;}
    public String getAdresseMail (){return this.adresseMail;}
    public String getNum() {return this.num;}
}

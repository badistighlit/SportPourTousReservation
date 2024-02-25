package domain;

public class Client {
     private int id;
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
    public void setId(int id) {this.id=id;}
    public int getId(){return this.id;}

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresseMail='" + adresseMail + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

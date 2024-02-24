package application.port.in;

import java.util.Objects;


public final class CreateClientCommand {

    private final String nom;
    private final String prenom;
    private final String adresseMail;
    private final String num;

    public CreateClientCommand(String nom, String prenom, String adresseMail, String num) {
        this.nom = Objects.requireNonNull(nom);
        this.prenom = Objects.requireNonNull(prenom);
        this.adresseMail = Objects.requireNonNull(adresseMail);
        this.num = Objects.requireNonNull(num);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public String getNum() {
        return num;
    }
}
package domain;

// Dans le fichier Reservation.java

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Reservation {
    private int id;
    private LocalDateTime dateHeure;
    private double caution;
    private double paiement;

    // Relations avec Client et Activité
    private Client client;
    private Activite activite;

    private List<PrestationSupplementaire> prestations = new ArrayList<>();
    List<Materiel> Materiels = new ArrayList<>();

    public Reservation(LocalDateTime dateHeure, double caution, double paiement, Client client, Activite activite) {

        this.dateHeure = dateHeure;
        this.caution = caution;
        this.paiement = paiement;
        this.client = client;
        this.activite = activite;
    }
    // constructeur sans caution pour les clients qui ont déja khalas
    public Reservation(LocalDateTime dateHeure,double paiement, Client client, Activite activite) {

        this.dateHeure = dateHeure;
        this.caution = caution;
        this.paiement = paiement;
        this.client = client;
        this.activite = activite;
    }
    public void setMateriel(Materiel m) {
        this.Materiels.add(m);
    }

    public void addPrestations(PrestationSupplementaire p) {this.prestations.add(p);}


}


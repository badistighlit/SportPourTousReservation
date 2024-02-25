package domain;

// Dans le fichier Reservation.java

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Reservation {
    private int id;
    private LocalDateTime dateHeure;
    private double caution;
    private String paiement;

    // Relations avec Client et Activité
    private Client client;
    private Activite activite;

    private List<PrestationSupplementaire> prestations = new ArrayList<>();
    List<Materiel> Materiels = new ArrayList<>();

    public Reservation(LocalDateTime dateHeure, double caution, String paiement, Client client, Activite activite) {

        this.dateHeure = dateHeure;
        this.caution = caution;
        this.paiement = paiement;
        this.client = client;
        this.activite = activite;
    }
    // constructeur sans caution pour les clients qui ont déja khalas
    public Reservation(LocalDateTime dateHeure,String paiement, Client client, Activite activite) {

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


    public Integer getId() {
        return this.id;
    }

    public String getPaiement() {
        return paiement;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public List<Materiel> getMateriels() {
        return Materiels;
    }

    public Activite getActivite() {
        return activite;
    }

    public Client getClient() { return client; }

    public void setId(int id) {
         this.id=id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateHeure=" + dateHeure +
                ", caution=" + caution +
                ", paiement='" + paiement + '\'' +
                ", client=" + client +
                ", activite=" + activite +
                ", prestations=" + prestations +
                ", Materiels=" + Materiels +
                '}';
    }
}


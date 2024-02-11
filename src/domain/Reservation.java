package domain;

// Dans le fichier Reservation.java

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private String ID;
    private LocalDateTime dateHeure;
    private double caution;
    private double paiement;

    // Relations avec Client et Activité
    private Client client;
    private List<Activite> activites;

    public Reservation(String ID, LocalDateTime dateHeure, double caution, double paiement, Client client, List<Activite> activites) {
        this.ID = ID;
        this.dateHeure = dateHeure;
        this.caution = caution;
        this.paiement = paiement;
        this.client = client;
        this.activites = activites;
    }
}


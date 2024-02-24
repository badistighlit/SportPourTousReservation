package application.port.in;

import domain.Activite;

import java.time.LocalDateTime;
import java.util.Objects;

public final class ReservationCommand {

    public final LocalDateTime dateHeure;
    public  double caution=0.0;
    public final String paiement;
    public final Activite activite;


    public ReservationCommand(LocalDateTime dateHeure, String paiement, Activite activite ,double caution) {
        this.dateHeure = Objects.requireNonNull(dateHeure);
        this.caution = caution;
        this.paiement = paiement;
        this.activite = Objects.requireNonNull(activite);

    }
    public ReservationCommand(LocalDateTime dateHeure, String paiement, Activite activite ) {
        this.dateHeure = Objects.requireNonNull(dateHeure);
        this.paiement = paiement;
        this.activite = Objects.requireNonNull(activite);

    }
    public LocalDateTime getDateHeure(){return this.dateHeure;}
    public double getCaution(){return this.caution;}
    public String getPaiement(){return  this.paiement;}
    public Activite getActivite(){return  this.activite;}
}
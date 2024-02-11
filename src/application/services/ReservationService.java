package application.services;

import domain.Activite;
import domain.Client;
import domain.Materiel;
import domain.Reservation;

import java.time.LocalDateTime;

public class ReservationService {
    public Reservation createFirnstReservation(LocalDateTime dateHeure, double caution, double paiement, Client client, Activite activite) {

        return new Reservation(dateHeure,caution,paiement,client,activite);
    }
    public Reservation createReservation(LocalDateTime dateHeure, double paiement, Client client, Activite activite) {

        return new Reservation(dateHeure,paiement,client,activite);
    }

    public void setMateriels(Materiel m) {}


}

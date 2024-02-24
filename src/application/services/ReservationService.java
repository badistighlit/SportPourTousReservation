package application.services;

import application.port.out.ReservationRepository;
import domain.*;

import java.time.LocalDateTime;

public class ReservationService {
    private Reservation reservation;
    private ReservationRepository ReservationRepository;
    public ReservationService(ReservationRepository ReservationRepository){
        this.ReservationRepository=ReservationRepository;
    }

    public void createFirnstReservation(LocalDateTime dateHeure, double paiement, Client client, Activite activite, double caution) {
        this.reservation= new Reservation(dateHeure,caution,paiement,client,activite);

    }
    public void createReservation(LocalDateTime dateHeure, double paiement, Client client, Activite activite) {

        this.reservation = new Reservation(dateHeure,paiement,client,activite);
    }

    public void setMateriels(Materiel m) {
        this.reservation.setMateriel(m);

    }

    public void setPrestation(PrestationSupplementaire p ){
        this.reservation.addPrestations(p);
    }



}

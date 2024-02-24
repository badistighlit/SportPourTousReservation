package adapter.in;

import application.services.ReservationService;
import domain.Activite;
import domain.Client;

import java.time.LocalDateTime;

public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    public void reserve(LocalDateTime dateHeure, double paiement, Client client, Activite activite, double... caution){
        if(caution.length > 0){
            reservationService.createFirnstReservation(dateHeure,paiement,client,activite,caution[0]);
        }
        else reservationService.createReservation(dateHeure,paiement,client,activite);

    }

}

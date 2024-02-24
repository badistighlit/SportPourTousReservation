package application;

import domain.Activite;
import domain.Client;
import domain.Reservation;


public final class ReservationException extends RuntimeException{

    private ReservationException() {
    }

    private ReservationException(String message) { super(message); }

    public static ReservationException notFoundReservationId(int id){
        return new ReservationException(String.format("%s not found", id));
    }
    public static application.ReservationException exceededThreshold(Client client, Activite activite) {
        return new application.ReservationException(String.format("Reservation pas possible.",
                client,
                activite));
    }

}
/*    public static ReservationException exceededThreshold(Client client, Activite activite) {
        return new ReservationException(String.format("Reservation pas possible.",
                client,
                activite));
    }*/


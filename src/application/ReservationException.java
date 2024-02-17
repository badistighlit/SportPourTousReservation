package application;

import domain.Activite;
import domain.Client;

public class ReservationException extends RuntimeException {
    private  ReservationException(String m ){
        super();
    }
    public static ReservationException exceededThreshold(Client client, Activite activite) {
        return new ReservationException(String.format("Reservation pas possible.",
                client,
                activite));
    }
}

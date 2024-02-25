package application.events;

import domain.Reservation;
import kernel.Event;

public class ReservationEvent implements Event {

    private final Reservation reservation;

    public ReservationEvent(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() { return reservation; }

}

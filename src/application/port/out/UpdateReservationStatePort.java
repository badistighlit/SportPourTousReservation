package application.port.out;

import domain.Reservation;

public interface UpdateReservationStatePort {
    void update (Reservation reservation);
}

package application.port.out;

import domain.Reservation;

public interface LoadReservationPort {
    Reservation load (int reservationId);
}

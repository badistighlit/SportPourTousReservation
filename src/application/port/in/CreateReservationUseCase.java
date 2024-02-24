package application.port.in;

import application.services.ReservationService;
import domain.Reservation;

public interface CreateReservationUseCase {
        Reservation createReservation(ReservationService reservationService);
}

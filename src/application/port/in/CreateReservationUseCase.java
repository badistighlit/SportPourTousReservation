package application.port.in;

import domain.Materiel;
import domain.PrestationSupplementaire;
import domain.Reservation;

public interface CreateReservationUseCase {
        Reservation createReservation(ReservationCommand reservationCommand, CreateClientCommand createClientCommand);
        Reservation createFirnstReservation(ReservationCommand reservationCommand, CreateClientCommand createClientCommand);
         void setPrestation(PrestationSupplementaire p );
        void setMateriels(Materiel m);
}

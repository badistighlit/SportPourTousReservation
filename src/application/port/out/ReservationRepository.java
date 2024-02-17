package application.port.out;

import domain.Reservation;

public interface ReservationRepository {
    Reservation findById(int id);

    void save(Reservation reservation);
}

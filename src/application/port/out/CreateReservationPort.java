package application.port.out;

import domain.Reservation;

public interface CreateReservationPort {
//    Reservation findById(int id);

    void save(Reservation reservation);
}

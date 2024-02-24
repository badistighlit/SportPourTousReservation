package adapter.out;

import application.port.out.ReservationRepository;
import domain.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InMemoryReservationRepository implements ReservationRepository {

    private final ArrayList<Reservation> registry = new ArrayList<>();

    @Override
    public Reservation findById(int id) {
        return registry.get(id);
    }

    @Override
    public void save(Reservation reservation) {
        registry.add (reservation);
        reservation.setId(registry.indexOf(reservation));
    }
}

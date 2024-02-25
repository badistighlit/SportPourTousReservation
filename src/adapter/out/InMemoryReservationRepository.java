package adapter.out;

import application.port.out.CreateReservationPort;
import application.port.out.LoadReservationPort;
import application.port.out.ReservationRepository;
import application.port.out.UpdateReservationStatePort;
import domain.Reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InMemoryReservationRepository implements CreateReservationPort, LoadReservationPort, UpdateReservationStatePort {

    private final ArrayList<Reservation> registry = new ArrayList<>();
    /*
    @Override
    public Reservation findById(int id) {
        return registry.get(id);
    }*/

    @Override
    public void save(Reservation reservation) {
        registry.add (reservation);
        reservation.setId(registry.indexOf(reservation));
    }

    @Override
    public Reservation load(int id) {
        return registry.get(id);
    }

    @Override
    public void update(Reservation reservation) {
        if(this.load(reservation.getId())!=null){
            this.registry.set(reservation.getId(),reservation);
        }
    }

    public ArrayList<Reservation> getAll(){return this.registry;}
}

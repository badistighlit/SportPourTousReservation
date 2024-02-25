package application.port.out;

import domain.Client;
import domain.Reservation;

public interface CreateClientPort {
    //Reservation nextId();

    void save(Client client);

    public Client findByEmail (String mail);
}

package application.port.out;

import domain.Client;
import domain.Reservation;

public interface LoadCLientPort {
    Client loadById(int ClientId);
    Client loadByMail (String mail);
}

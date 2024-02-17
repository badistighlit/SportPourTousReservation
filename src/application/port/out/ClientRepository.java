package application.port.out;

import domain.Client;

public interface ClientRepository {
    Client findById(int id);

    void save(Client client);
}

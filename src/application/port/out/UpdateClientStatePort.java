package application.port.out;

import domain.Client;

public interface UpdateClientStatePort {
    void update(Client client);
}

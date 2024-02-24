package adapter.out;

import application.port.out.ClientRepository;
import domain.Client;
import domain.Reservation;

import java.util.ArrayList;

public class InMemoryClientRepository implements ClientRepository {
    private final ArrayList<Client> registry = new ArrayList<>();
    @Override
    public Client findById(int id) {
        return null;
    }

    @Override
    public void save(Client client) {
        this.registry.add(client);

    }

    @Override
    public Client findByEmail(String email) {
        return null;
    }
}

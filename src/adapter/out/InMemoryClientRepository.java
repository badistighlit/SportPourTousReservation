package adapter.out;

import application.port.out.CreateClientPort;
import application.port.out.LoadCLientPort;
import application.port.out.UpdateClientStatePort;
import domain.Client;

import java.util.ArrayList;

public class InMemoryClientRepository implements CreateClientPort, LoadCLientPort, UpdateClientStatePort {
    private final ArrayList<Client> registry = new ArrayList<>();

    /*public Client findById(int id) {
        return null;
    }*/

    @Override
    public void save(Client client) {
        this.registry.add(client);
        client.setId(registry.indexOf(client));

    }

    @Override
    public Client loadByMail(String email) {
        for (Client c : this.registry){
            if(c.getAdresseMail().equals(email)) return c;
    }
        return null;
}
    @Override
    public Client findByEmail(String email){
        return this.loadByMail(email);
    }
    @Override
    public Client loadById(int id) {
        if(this.registry.get(id)!=null) return this.registry.get(id);
        return null;
    }




    @Override
    public void update(Client client) {
        if(this.loadByMail(client.getAdresseMail())!=null){
            this.registry.set(client.getId(),client);
        }

    }
}

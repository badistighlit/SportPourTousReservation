package adapter.in;

import application.services.ClientService;
import domain.Client;

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client inscription(int id, String nom, String prenom, String adresseMail, String num) {
        return this.clientService.createClient(id, nom, prenom, adresseMail, num);
    }

}

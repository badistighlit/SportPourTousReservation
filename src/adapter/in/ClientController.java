package adapter.in;

import application.port.in.CreateClientCommand;
import application.port.in.CreateClientUseCase;
import application.services.ClientService;
import domain.Client;

public class ClientController {

    private final CreateClientUseCase createClientUseCase;

    public ClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    public Client inscription(int id, String nom, String prenom, String adresseMail, String num) {

        return this.createClientUseCase.createClient(new CreateClientCommand( nom, prenom, adresseMail, num));
    }

}

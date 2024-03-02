package application.services;

import application.ClientEmailAlreadyExistsException;
import application.port.in.CreateClientCommand;
import application.port.in.CreateClientUseCase;
import application.port.out.CreateClientPort;
import domain.Client;

public final class ClientService implements CreateClientUseCase {

    private Client client;
    final private CreateClientPort createClientPort;
    public ClientService(CreateClientPort createClientPort){
        this.createClientPort = createClientPort;
    }

    @Override
    public Client createClient(CreateClientCommand createClientCommand) {

        if (createClientPort.findByEmail(createClientCommand.getAdresseMail()) != null) {
            throw new ClientEmailAlreadyExistsException("un compte existe déja avec cette adresse mail.");
        }


        if (createClientCommand.getNom().isBlank() ||
                createClientCommand.getPrenom().isBlank() ||
                createClientCommand.getAdresseMail().isBlank() ||
                createClientCommand.getNum().isBlank()) {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }


        Client client = new Client(0,
                createClientCommand.getNom(),
                createClientCommand.getPrenom(),
                createClientCommand.getAdresseMail(),
                createClientCommand.getNum());

        createClientPort.save(client);
        return client;
    }

    public Client getClient(String mail ){
        return this.createClientPort.findByEmail(mail);
    }
}

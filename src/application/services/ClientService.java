package application.services;

import application.port.in.CreateClientCommand;
import application.port.in.CreateClientUseCase;
import application.port.out.ClientRepository;
import domain.Client;

public final class ClientService implements CreateClientUseCase {

    private Client client;
    final private ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(CreateClientCommand createClientCommand) {

        if (clientRepository.findByEmail(createClientCommand.getAdresseMail()) != null) {
            throw new IllegalArgumentException("Un compte avec cette adresse e-mail existe déjà");
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

        clientRepository.save(client);
        return client;
    }
}

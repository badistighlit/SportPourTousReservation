package application.services;

import application.port.out.ClientRepository;
import domain.Client;

public class CreateAccountService {

    private Client client;
    final private ClientRepository clientRepository;
    public CreateAccountService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client) {
        if (client.getNom() == null || client.getNom().isEmpty() ||
                client.getPrenom() == null || client.getPrenom().isEmpty() ||
                client.getAdresseMail() == null || client.getAdresseMail().isEmpty() ||
                client.getNum() == null || client.getNum().isEmpty()) {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }

        if (clientRepository.findByEmail(client.getAdresseMail()) != null) {
            throw new IllegalArgumentException("Un compte avec cette adresse e-mail existe déjà");
        }

        clientRepository.save(client);
    }

}

package application.services;

import application.port.out.ClientRepository;
import domain.Client;

public class ClientService {

    private Client client;
    final private ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client createClient(int id, String nom, String prenom, String adresseMail, String num) {

        Client client = new Client(id, nom, prenom, adresseMail, num);

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
        return client;
    }

}

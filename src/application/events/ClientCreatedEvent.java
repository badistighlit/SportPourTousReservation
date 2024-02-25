package application.events;

import domain.Client;
import kernel.Event;

public class ClientCreatedEvent implements Event {

    private final Client client;

    public ClientCreatedEvent(Client client) {
        this.client = client;
    }

    public Client getClientMail() { return client;}

}

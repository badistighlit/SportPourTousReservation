package application.services;

import application.events.ClientCreatedEvent;
import application.port.out.Notifications;
import kernel.EventHandler;

public class ClientCreatedEventHandler implements EventHandler<ClientCreatedEvent> {

    private final Notifications notifications;

    public ClientCreatedEventHandler(Notifications notifications) {this.notifications = notifications; }

    @Override
    public void handle(ClientCreatedEvent event) {
        notifications.notify(String.format("Notification of the client creation %s", event.getClientMail()));
    }
}

package application.services;

import application.events.ClientCreatedEvent;
import application.events.ReservationEvent;
import application.port.out.Notifications;
import kernel.EventHandler;

public class ReservationCreatedEventHandler implements EventHandler<ReservationEvent> {

    private final Notifications notifications;

    public ReservationCreatedEventHandler(Notifications notifications) {this.notifications = notifications; }

    @Override
    public void handle(ReservationEvent event) {
        notifications.notify(String.format("Notification of the reservation creation for %s with the activity %s",
                event.getReservation().getClient().getAdresseMail(), event.getReservation().getActivite().getNom()));
    }
}

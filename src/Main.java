import adapter.in.ReservationController;
import adapter.out.InMemoryClientRepository;
import adapter.out.InMemoryReservationRepository;
import adapter.out.LogNotifications;
import application.events.ClientCreatedEvent;
import application.events.ReservationEvent;
import application.services.ClientCreatedEventHandler;
import application.services.CreateReservationService;
import application.services.ReservationCreatedEventHandler;
import domain.Activite;
import domain.Client;
import domain.Reservation;
import kernel.DefaultEventDispatcher;
import kernel.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    //LocalDateTime dateHeure, String paiement, Client client, Activite activite, double... caution)
    public static void main(String [] args){

        var eventDispatcher = DefaultEventDispatcher.<ReservationEvent>create(); // Définir explicitement le type de l'événement comme ReservationEvent
        var notifications = new LogNotifications();
        var reservationCreatedEventHandler = new ReservationCreatedEventHandler(notifications);

        InMemoryReservationRepository p = new InMemoryReservationRepository() ;
        InMemoryClientRepository h = new InMemoryClientRepository();
        CreateReservationService s = new CreateReservationService(p,h, eventDispatcher);
        ReservationController c = new ReservationController(s);

        eventDispatcher.register(ReservationEvent.class, reservationCreatedEventHandler);

        Reservation sp = c.reserve(LocalDateTime.now(),"CB", new Client(23,"badis","tighlit","badis@gmail","06666"),new Activite("foot","foot"), 2.0);

        Reservation ss = c.reserve(LocalDateTime.now(),"CB", new Client(23,"badis","tighlit","badis@gmail","0666996"),new Activite("foot","foot"));
        System.out.println(h.getRegistry());
        System.out.println(p.getAll());


    }

}

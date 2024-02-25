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

        Reservation ss = c.reserve(LocalDateTime.now(),"CB", new Client(23,"badis","tighlit","badisssss@gmail","0666996"),new Activite("foot","foot"),2.0);

        Reservation sss = c.reserve(LocalDateTime.now(),"CB", new Client(23,"badis","tighlit","bassssdis@gmail","06666"),new Activite("foot","foot"),2.0);
        /*
        InMemoryClientRepository cr = new InMemoryClientRepository();
        ClientService cs = new ClientService(cr);
        ClientController cc = new ClientController(cs);
        Client c =cc.inscription(23,"badis","sa","badis@gmail","0666");
        System.out.println(c.getNom()+" "+c.getNum()+" "+c.getAdresseMail());
        Client c2 =cc.inscription(25,"badi2","sa2","badis@gmail","0DDDD666");
        System.out.println(c2.getNom()+" "+c2.getNum()+" "+c2.getAdresseMail());*/
    }

}

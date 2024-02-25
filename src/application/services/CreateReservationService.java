package application.services;

import adapter.out.InMemoryClientRepository;
import adapter.out.InMemoryReservationRepository;
import application.events.ReservationEvent;
import application.port.in.CreateClientCommand;
import application.port.in.CreateReservationUseCase;
import application.port.in.ReservationCommand;
import application.port.out.CreateClientPort;
import application.port.out.CreateReservationPort;
import application.port.out.ReservationRepository;
import domain.Materiel;
import domain.PrestationSupplementaire;
import domain.Reservation;
import kernel.DefaultEventDispatcher;
import kernel.Event;
import kernel.EventDispatcher;

public class CreateReservationService implements CreateReservationUseCase {

    private final CreateReservationPort createReservationPort;
    private final ClientService clientService;
    private final EventDispatcher<? super ReservationEvent> eventDispatcher;

    public CreateReservationService(CreateReservationPort createReservationPort, CreateClientPort createClientPort, EventDispatcher<? super ReservationEvent> eventDispatcher){
        this.createReservationPort=createReservationPort;
        this.clientService = new ClientService(createClientPort);
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Reservation createReservation(ReservationCommand reservationCommand, CreateClientCommand createClientCommand) {
        if (createClientCommand == null || reservationCommand.paiement.isBlank() )  {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }


        Reservation reservation = new Reservation(reservationCommand.getDateHeure(),
                                                  reservationCommand.getCaution(),
                                                  reservationCommand.getPaiement(),
                                                  clientService.getClient(createClientCommand.getAdresseMail()),
                                                  reservationCommand.activite);
        this.createReservationPort.save(reservation);
        this.eventDispatcher.dispacth(new ReservationEvent(reservation));
        return reservation;
    }

    @Override
    public Reservation createFirnstReservation(ReservationCommand reservationCommand, CreateClientCommand createClientCommand) {
        if (createClientCommand == null || reservationCommand.paiement.isBlank()
                || reservationCommand.caution == 0.0
                )  {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }

        Reservation reservation = new Reservation(reservationCommand.getDateHeure(),
                reservationCommand.getPaiement(),
                clientService.createClient(createClientCommand),
                reservationCommand.activite);
        this.createReservationPort.save(reservation);
        this.eventDispatcher.dispacth(new ReservationEvent(reservation));
        return reservation;
    }

    @Override
    public void setPrestation(PrestationSupplementaire p) {

    }

    @Override
    public void setMateriels(Materiel m) {

    }
}

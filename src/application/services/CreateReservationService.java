package application.services;

import application.port.in.CreateClientCommand;
import application.port.in.CreateReservationUseCase;
import application.port.in.ReservationCommand;
import application.port.out.CreateClientPort;
import application.port.out.CreateReservationPort;
import application.port.out.ReservationRepository;
import domain.Materiel;
import domain.PrestationSupplementaire;
import domain.Reservation;

public class CreateReservationService implements CreateReservationUseCase {

    private CreateReservationPort createReservationPort;
    private ClientService clientService;
    public CreateReservationService(CreateReservationPort createReservationPort, CreateClientPort createClientPort){
        this.createReservationPort=createReservationPort;
        this.clientService = new ClientService(createClientPort);
    }

    @Override
    public Reservation createReservation(ReservationCommand reservationCommand, CreateClientCommand createClientCommand) {
        if (createClientCommand==null ||
                reservationCommand.activite==null ||
                reservationCommand.dateHeure==null ||
                reservationCommand.paiement.isBlank()||
                reservationCommand.caution == 0.0)  {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }

        Reservation reservation = new Reservation(reservationCommand.getDateHeure(),
                                                  reservationCommand.getCaution(),
                                                  reservationCommand.getPaiement(),
                                                  clientService.createClient(createClientCommand),
                                                  reservationCommand.activite);
        this.createReservationPort.save(reservation);
        return reservation;
    }

    @Override
    public Reservation createFirnstReservation(ReservationCommand reservationCommand, CreateClientCommand createClientCommand) {
        if (createClientCommand==null ||
                reservationCommand.activite==null ||
                reservationCommand.dateHeure==null ||
                reservationCommand.paiement.isBlank()
                )  {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }

        Reservation reservation = new Reservation(reservationCommand.getDateHeure(),
                reservationCommand.getPaiement(),
                clientService.createClient(createClientCommand),
                reservationCommand.activite);
        this.createReservationPort.save(reservation);
        return reservation;
    }

    @Override
    public void setPrestation(PrestationSupplementaire p) {

    }

    @Override
    public void setMateriels(Materiel m) {

    }
}

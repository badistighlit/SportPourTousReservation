package application.services;

import application.port.in.CreateClientCommand;
import application.port.in.CreateReservationUseCase;
import application.port.in.ReservationCommand;
import application.port.out.ClientRepository;
import application.port.out.ReservationRepository;
import domain.Materiel;
import domain.PrestationSupplementaire;
import domain.Reservation;

public class CreateReservationService implements CreateReservationUseCase {

    private application.port.out.ReservationRepository ReservationRepository;
    private ClientService clientService;
    public CreateReservationService(ReservationRepository ReservationRepository, ClientRepository clientRepository){
        this.ReservationRepository=ReservationRepository;
        this.clientService = new ClientService(clientRepository);
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
        this.ReservationRepository.save(reservation);
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
        this.ReservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public void setPrestation(PrestationSupplementaire p) {

    }

    @Override
    public void setMateriels(Materiel m) {

    }
}

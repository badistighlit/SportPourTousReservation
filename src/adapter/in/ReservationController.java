package adapter.in;

import application.port.in.CreateClientCommand;
import application.port.in.CreateReservationUseCase;
import application.port.in.ReservationCommand;
import domain.Activite;
import domain.Client;
import domain.Reservation;

import java.time.LocalDateTime;

public class ReservationController {
    private final CreateReservationUseCase createReservationUseCase;

    public ReservationController(CreateReservationUseCase createReservationUseCase){
        this.createReservationUseCase = createReservationUseCase;
    }
    public Reservation reserve(LocalDateTime dateHeure, String paiement, Client client, Activite activite, double... caution){
        CreateClientCommand createClientCommand = new CreateClientCommand(client.getNom(), client.getPrenom(), client.getAdresseMail(), client.getNum());
        if(caution.length > 0){
          return  createReservationUseCase.createFirnstReservation(new ReservationCommand(dateHeure,paiement,activite,caution[0]),createClientCommand);
        }
        else return  createReservationUseCase.createReservation(new ReservationCommand(dateHeure,  paiement,activite),createClientCommand);


    }

}

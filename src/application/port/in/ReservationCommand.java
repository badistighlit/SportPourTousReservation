package application.port.in;

import domain.Activite;
import domain.Client;
import domain.Reservation;

import java.util.Objects;

public final class ReservationCommand {

    private final Client initialClient;
    private final Activite initialActivite;

    public ReservationCommand(Activite initialActivite, Client initialClient ) {
        this.initialActivite = Objects.requireNonNull(initialActivite);
        this.initialClient = Objects.requireNonNull(initialClient);

    }
}

package application.port.in;

import domain.Client;

import java.util.Objects;

public final class CreateAccountCommand {

    public final Client initialClient;

    public CreateAccountCommand(Client initialClient) {
        this.initialClient = initialClient;
    }
}

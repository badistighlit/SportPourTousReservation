package application.port.in;

import java.util.Objects;

public final class CreateClientCommand {

    public final String initialMail;

    public CreateClientCommand(String mail) {
        this.initialMail = Objects.requireNonNull(mail);
    }
}

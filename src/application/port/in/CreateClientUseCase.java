package application.port.in;

import domain.Client;

public interface CreateClientUseCase {
        Client createClient(CreateClientCommand createClientCommand);

}

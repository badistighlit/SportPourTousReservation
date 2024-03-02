package application;

public class ClientEmailAlreadyExistsException extends RuntimeException {
    public ClientEmailAlreadyExistsException(String message) {
        super(message);
    }
}


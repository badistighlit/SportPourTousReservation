package kernel;

public interface Event {
    default String name() {
        return getClass().getSimpleName();
    }
}

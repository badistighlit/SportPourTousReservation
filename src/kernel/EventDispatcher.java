package kernel;

public interface EventDispatcher<E extends Event> {

    void dispacth(E event);

    void register(Class<E> evenClass, EventHandler<E> handler);
}

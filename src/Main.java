import adapter.in.ClientController;
import adapter.out.InMemoryClientRepository;
import adapter.out.InMemoryReservationRepository;
import application.port.out.ClientRepository;
import application.services.ClientService;
import domain.Client;

public class Main {
    public static void main(String [] args){
        InMemoryClientRepository p = new InMemoryClientRepository() ;
        ClientService s = new ClientService(p);
        ClientController c = new ClientController(s);
        Client sp = c.inscription(0,"tighlit","badis","badis.","077");
        System.out.println(sp.getNom() + sp.getAdresseMail() + sp.getNum());
    }

}

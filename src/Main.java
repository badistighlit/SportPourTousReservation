import adapter.in.ClientController;
import adapter.in.ReservationController;
import adapter.out.InMemoryClientRepository;
import adapter.out.InMemoryReservationRepository;
import adapter.out.LogNotifications;
import application.events.ClientCreatedEvent;
import application.events.ReservationEvent;
import application.services.ClientCreatedEventHandler;
import application.services.ClientService;
import application.services.CreateReservationService;
import application.services.ReservationCreatedEventHandler;
import domain.*;
import kernel.DefaultEventDispatcher;
import kernel.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //LocalDateTime dateHeure, String paiement, Client client, Activite activite, double... caution)
  /*  public static void main(String [] args){

        var eventDispatcher = DefaultEventDispatcher.<ReservationEvent>create(); // Définir explicitement le type de l'événement comme ReservationEvent
        var notifications = new LogNotifications();
        var reservationCreatedEventHandler = new ReservationCreatedEventHandler(notifications);

        InMemoryReservationRepository p = new InMemoryReservationRepository() ;
        InMemoryClientRepository h = new InMemoryClientRepository();
        CreateReservationService s = new CreateReservationService(p,h, eventDispatcher);
        ReservationController c = new ReservationController(s);

        eventDispatcher.register(ReservationEvent.class, reservationCreatedEventHandler);

        Reservation sp = c.reserve(LocalDateTime.now(),"CB", new Client(23,"badis","tighlit","badis@gmail","06666"),new Activite("foot","foot"), 2.0);

        Reservation ss = c.reserve(LocalDateTime.now(),"CB", new Client(23,"badis","tighlit","badis@gmail","0666996"),new Activite("foot","foot"));
        System.out.println(h.getRegistry());
        System.out.println(p.getAll());


    }
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var eventDispatcher = DefaultEventDispatcher.<ReservationEvent>create();
        var notifications = new LogNotifications();
        var reservationCreatedEventHandler = new ReservationCreatedEventHandler(notifications);


        InMemoryReservationRepository reservationRepository = new InMemoryReservationRepository();
        InMemoryClientRepository clientRepository = new InMemoryClientRepository();
        CreateReservationService reservationService = new CreateReservationService(reservationRepository, clientRepository, eventDispatcher);
        ReservationController reservationController = new ReservationController(reservationService);
        ClientService cs = new ClientService(clientRepository);
        ClientController c = new ClientController(cs);
        c.inscription(0,"tighlit","badis","badis@gmail","066666");
        eventDispatcher.register(ReservationEvent.class, reservationCreatedEventHandler);

        // Créer une liste d'activités prédéfinies
        List<Activite> activitesDisponibles = new ArrayList<>();
        activitesDisponibles.add(new Activite("Football", "Jeu de ballon entre deux équipes."));
        activitesDisponibles.add(new Activite("Natation", "Activité aquatique dans une piscine."));
        activitesDisponibles.add(new Activite("Course à pied", "Course à pied en plein air."));
        activitesDisponibles.add(new Activite("Basket-ball", "Jeu de ballon en équipe avec des paniers."));

        System.out.println("Bienvenue sur notre service de réservation d'activités!");
        System.out.println("----------------------------");

        // Demander à l'utilisateur s'il a déjà un compte
        System.out.print("Avez-vous déjà un compte? (O/N) : ");
        String reponseCompte = scanner.next();

        Client client;
        if ("O".equalsIgnoreCase(reponseCompte)) {
            // L'utilisateur a déjà un compte, demandez ses informations
            System.out.print("Veuillez saisir votre email : ");
            String mail = scanner.next();
            client = clientRepository.findByEmail(mail);

            if (client == null) {
                System.out.println("Aucun utilisateur trouvé avec cet identifiant. Créez un compte.");
                return;
            }
        } else {
            // L'utilisateur n'a pas de compte, demandez-lui de créer un compte
            System.out.print("Veuillez saisir votre nom : ");
            String nomClient = scanner.next();
            System.out.print("Veuillez saisir votre prénom : ");
            String prenomClient = scanner.next();
            System.out.print("Veuillez saisir votre adresse e-mail : ");
            String emailClient = scanner.next();
            System.out.print("Veuillez saisir votre numéro : ");
            String numeroClient = scanner.next();

            client = new Client(9, nomClient, prenomClient, emailClient, numeroClient);
            clientRepository.save(client);

            System.out.println("Compte créé avec succès! Votre identifiant est : " + client.getId());
        }

        // Proposez des activités à l'utilisateur
        System.out.println("Voici quelques activités disponibles :");

        // Affichez les activités avec des numéros
        for (int i = 0; i < activitesDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + activitesDisponibles.get(i).getNom());
        }

        // Demandez à l'utilisateur de choisir une activité
        System.out.print("Veuillez saisir le numéro de l'activité que vous souhaitez réserver : ");
        int numeroActivite = scanner.nextInt();

        // Vérifiez si le numéro de l'activité est valide
        if (numeroActivite > 0 && numeroActivite <= activitesDisponibles.size()) {
            // Récupérez l'activité sélectionnée par l'utilisateur
            Activite activiteSelectionnee = activitesDisponibles.get(numeroActivite - 1);

            // Demandez à l'utilisateur de saisir les détails de la réservation
            System.out.println("Vous avez choisi l'activité : " + activiteSelectionnee.getNom());
            System.out.print("Veuillez saisir la date et l'heure de la réservation (AAAA-MM-JJTHH:MM) veuillez respecter ce format: ");
            String dateHeureStr = scanner.next();
            LocalDateTime dateHeure = LocalDateTime.parse(dateHeureStr.replace(' ', 'T'));
            System.out.print("Veuillez saisir le mode de paiement : ");
            String modePaiement = scanner.next();

            // Créer la réservation
            Reservation reservation = reservationController.reserve(dateHeure, modePaiement, client, activiteSelectionnee);

            // Proposez des prestations supplémentaires à l'utilisateur
            System.out.print("Souhaitez-vous ajouter des prestations supplémentaires? (O/N) : ");
            String reponsePrestations = scanner.next();

            List<PrestationSupplementaire> prestationsSelectionnees = new ArrayList<>();
            while ("O".equalsIgnoreCase(reponsePrestations)) {
                System.out.println("Voici quelques prestations supplémentaires disponibles :");
                System.out.println("1. Plateau Repas");
                System.out.println("2. Navette");
                System.out.print("Veuillez saisir le numéro de la prestation que vous souhaitez ajouter (0 pour terminer) : ");
                int numeroPrestation = scanner.nextInt();

                if (numeroPrestation == 0) {
                    break;  // L'utilisateur a terminé de sélectionner des prestations
                }

                PrestationSupplementaire prestationSelectionnee = null;

                // Vérifiez le choix de l'utilisateur
                switch (numeroPrestation) {
                    case 1:
                        prestationSelectionnee = new PlateauRepas("Plateau Repas", "Nourriture pour votre réservation", 20.0);
                        break;
                    case 2:
                        prestationSelectionnee = new Navette("Navette", "Transport pour votre réservation", 15.0);
                        break;
                    default:
                        System.out.println("Numéro de prestation non valide. Veuillez saisir un numéro valide.");
                }

                if (prestationSelectionnee != null) {
                    prestationsSelectionnees.add(prestationSelectionnee);
                    System.out.println("Prestation ajoutée : " + prestationSelectionnee.getNom());
                }

                // Demandez à l'utilisateur s'il souhaite ajouter une autre prestation
                System.out.print("Souhaitez-vous ajouter une autre prestation? (O/N) : ");
                reponsePrestations = scanner.next();
            }

            // Ajoutez les prestations sélectionnées à la réservation
            for (PrestationSupplementaire prestation : prestationsSelectionnees) {
                reservation.addPrestations(prestation);
            }

            // Proposez la location de matériel ou d'un terrain
            System.out.print("Souhaitez-vous louer du matériel ou un terrain? (O/N) : ");
            String reponseLocation = scanner.next();

            while ("O".equalsIgnoreCase(reponseLocation)) {
                System.out.println("Voici quelques options de location disponibles :");
                System.out.println("1. Location de matériel");
                System.out.println("2. Location de terrain");
                System.out.print("Veuillez saisir le numéro de l'option que vous souhaitez (0 pour terminer) : ");
                int numeroLocation = scanner.nextInt();

                if (numeroLocation == 0) {
                    break;  // L'utilisateur a terminé la location
                }

                // Ajoutez la location de matériel ou de terrain à la réservation
                switch (numeroLocation) {
                    case 1:
                        System.out.print("Veuillez saisir le nom du matériel que vous souhaitez louer : ");
                        String nomMateriel = scanner.next();
                        System.out.print("Veuillez saisir le type du matériel : ");
                        String typeMateriel = scanner.next();
                        System.out.print("Veuillez saisir la caution du matériel : ");
                        double cautionMateriel = scanner.nextDouble();

                        Materiel materiel = new Materiel(1, nomMateriel, typeMateriel, cautionMateriel);
                        reservation.setMateriel(materiel);
                        System.out.println("Matériel ajouté à la réservation : " + materiel.getNom());
                        break;

                    case 2:
                        System.out.print("Veuillez saisir le type du terrain que vous souhaitez louer : ");
                        String typeTerrain = scanner.next();
                        System.out.print("Veuillez saisir le numéro du terrain : ");
                        String numeroTerrain = scanner.next();
                        System.out.print("Veuillez saisir l'adresse du terrain : ");
                        String adresseTerrain = scanner.next();

                        Terrain terrain = new Terrain(typeTerrain, numeroTerrain, adresseTerrain);
                        // ... (ajoutez la logique pour gérer la location de terrain)
                        System.out.println("Terrain ajouté à la réservation : " + terrain.getType());
                        break;

                    default:
                        System.out.println("Numéro d'option non valide. Veuillez saisir un numéro valide.");
                }

                // Demandez à l'utilisateur s'il souhaite ajouter une autre location
                System.out.print("Souhaitez-vous ajouter une autre location? (O/N) : ");
                reponseLocation = scanner.next();
            }

            // Imprimer les informations de la réservation
            System.out.println("Réservation créée avec succès!");
            System.out.println("Informations de la réservation :");
            System.out.println(reservation);

        } else {
            System.out.println("Numéro d'activité non valide. Veuillez saisir un numéro valide.");
        }

        scanner.close();
    }
}


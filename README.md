# Sport pour tous - ARCHITECTURE HEXAGONAL

Bienvenue sur notre service de SPORT POUR TOUS! Ce projet permet aux utilisateurs de réserver des activités, de choisir des prestations supplémentaires, et de louer du matériel ou un terrain.

#Prérequis
Assurez-vous d'avoir Java installé sur votre machine.

#Comment exécuter
Clonez le projet sur votre machine locale.
Naviguez vers le répertoire du projet.
Exécutez le fichier Main.java qui contient la classe principale du programme.

javac Main.java 
ensuite
java Main.Java

Suivez les instructions à l'écran pour créer un compte, choisir une activité, spécifier la date et l'heure de la réservation, sélectionner des prestations supplémentaires, et éventuellement louer du matériel ou un terrain.

#Structure du Projet HEXAGONAL

**domain:** Contient les classes métier telles que Client, Activite, Materiel, Terrain, et Reservation.
**adapter: **Gère les adaptateurs pour les entrées et sorties. Les classes ClientController et ReservationController gèrent les interactions utilisateur,et les InMemoryClientRepository, InMemoryReservationRepository gère le stockage.
**application:** Inclut les services métier tels que ClientService et CreateReservationService, les ports d'entrées et sorties ainsi que les events.
**kernel:** Comprend la classe DefaultEventDispatcher pour la gestion des événements.
#Fonctionnalités Principales
1. Création de compte client.
1. Réservation d'activités.
1. Ajout de prestations supplémentaires.
1. Location de matériel ou de terrain.

#Remarques
Le projet utilise une implémentation mémoire pour stocker les informations des clients et des réservations (InMemoryClientRepository et InMemoryReservationRepository).
Les événements tels que la création de réservations sont gérés par DefaultEventDispatcher.
N'oubliez pas de fournir une adresse e-mail valide lors de la création du compte pour éviter tout problème lors de la recherche de comptes existants.
N'oubliez pas de respecter le format date suivat : AAAA-MM-JJTHH-MM , où 'T' sert de séparateur entre la date et l'heure

Amusez-vous bien en utilisant notre service de réservation d'activités!

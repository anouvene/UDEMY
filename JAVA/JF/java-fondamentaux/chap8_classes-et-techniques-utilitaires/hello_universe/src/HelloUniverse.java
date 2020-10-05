import java.util.Scanner;

public class HelloUniverse {

    public static void main(String... args) {
        // Planètes
        PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
        mercure.diametre = 4880;

        PlaneteTellurique venus = new PlaneteTellurique("Venus");
        venus.diametre = 12100;

        PlaneteTellurique terre = new PlaneteTellurique("Terre");
        terre.diametre = 12756;

        PlaneteTellurique mars = new PlaneteTellurique("Mars");
        mars.diametre = 6792;

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        // Scanner
        Scanner sc = new Scanner(System.in);

        // Vaisseaux
        Vaisseau chasseur = new VaisseauDeGuerre("CHASSEUR");
        chasseur.nbPassagers = 20;

        Vaisseau fregate = new VaisseauDeGuerre("FREGATE");
        fregate.nbPassagers = 100;

        Vaisseau croiseur = new VaisseauDeGuerre("CROISEUR");
        croiseur.nbPassagers = 125;

        Vaisseau cargo = new VaisseauCivil("CARGO");
        cargo.nbPassagers = 99;

        Vaisseau vaisseauMonde = new VaisseauCivil("VAISSEAU-MONDE");
        vaisseauMonde.nbPassagers = 256;

        System.out.println("Veuillez choisir un type de vaisseau suivants: chasseur, fregate, croiseur, cargo, vaisseau-monde");
        String type = sc.nextLine();

        System.out.println("Sur quelle planete tellurique le vaisseau va t-il atterrir ?: mercure, venus, terre, mars");
        String planete = sc.nextLine();

        System.out.println("Veuillez saisir le tonnage de cargaison ?");
        int tonnage = sc.nextInt();

        Vaisseau choixVaisseau = null;
        PlaneteTellurique choixPlaneteTellurique = null;

        switch(planete.toUpperCase()) {
            case "MERCURE":
                choixPlaneteTellurique = mercure;
                break;
            case "VENUS":
                choixPlaneteTellurique = venus;
                break;
            case "TERRE":
                choixPlaneteTellurique = terre;
                break;
            case "MARS":
                choixPlaneteTellurique = mars;
                break;
        }

        switch(type.toUpperCase()) {
            case "CHASSEUR":
                choixVaisseau = chasseur;
                break;
            case "FREGATE":
                choixVaisseau = fregate;
                break;
            case "CROISEUR":
                choixVaisseau = croiseur;
                break;
            case "CARGO":
                choixVaisseau = cargo;
                break;
            case "VAISSEAU-MONDE":
                choixVaisseau = vaisseauMonde;
                break;
        }

        choixPlaneteTellurique.accueillirVaisseau(choixVaisseau);
        System.out.println("Le vaisseau " + type + " a rejeté : " + choixVaisseau.emporterCargaison(tonnage)+" tonnes.");

    }

}
import java.util.Scanner;

public class HelloUniverse {

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 3);
        terre.diametre = 12756;
        PlaneteTellurique mars = new PlaneteTellurique("Mars", 4);

        mars.diametre = 6792;
        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo.nbPassagers = 10000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        Scanner sc = new Scanner(System.in);
        boolean saisie = true;

        while(saisie) {
            System.out.println("Quel vaisseau souhaitez vous manipuler : "+TypeVaisseau.CHASSEUR.name()+", "+TypeVaisseau.FREGATE.name()+", "+TypeVaisseau.CROISEUR.name()+", "+TypeVaisseau.CARGO.name()+" ou "+TypeVaisseau.VAISSEAUMONDE.name()+" ?");
            String typeVaisseauString = sc.nextLine();
            TypeVaisseau typeVaisseau=TypeVaisseau.valueOf(typeVaisseauString);
            Vaisseau vaisseauSelectionne = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseauSelectionne = chasseur;
                    break;
                case FREGATE:
                    vaisseauSelectionne = fregate;
                    break;
                case CROISEUR:
                    vaisseauSelectionne = croiseur;
                    break;
                case CARGO:
                    vaisseauSelectionne = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseauSelectionne = vaisseauMonde;
                    break;
            }

            System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser : Mercure, Venus, Terre ou Mars ?");
            String nomPlanete = sc.nextLine();
            PlaneteTellurique planeteSelectionnee = null;
            switch (nomPlanete) {
                case "Mercure":
                    planeteSelectionnee = mercure;
                    break;
                case "Venus":
                    planeteSelectionnee = venus;
                    break;
                case "Terre":
                    planeteSelectionnee = terre;
                    break;
                case "Mars":
                    planeteSelectionnee = mars;
                    break;

            }

            System.out.println("Quel tonnage souhaitez-vous emporter ?");
            int tonnageSouhaite = sc.nextInt();

            if(planeteSelectionnee.restePlaceDisponible()) {
                planeteSelectionnee.accueillirVaisseau(vaisseauSelectionne);
                System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
            } else {
                System.out.println("le vaisseau ne peut pas se poser sur la planète " + planeteSelectionnee.nom + " par manque de place das la baie");
            }

            System.out.println("Voulez-vous recommencer oui/non?");
            sc.nextLine();

            if(sc.nextLine().equalsIgnoreCase("non")) {
                saisie = false;
            }

        }
    }

}

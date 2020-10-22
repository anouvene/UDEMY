import java.util.Scanner;

public class HelloUniverse {

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        PlaneteTellurique terre = new PlaneteTellurique("Terre", 100);
        terre.diametre = 12756;
        PlaneteTellurique mars = new PlaneteTellurique("Mars", 5);
        mars.diametre = 6792;
        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        Vaisseau chasseur1 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur1.nbPassagers = 3;
        chasseur1.blindage = 156;
        chasseur1.resistanceDuBouclier = 2;

        Vaisseau chasseur2 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur2.nbPassagers = 1;
        chasseur2.blindage = 80;
        chasseur2.resistanceDuBouclier = 2;

        Vaisseau chasseur3 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur3.nbPassagers = 2;
        chasseur3.blindage = 100;
        chasseur3.resistanceDuBouclier = 2;

        Vaisseau[] chasseurs = {chasseur1, chasseur2, chasseur3};

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau[] croiseurs = {croiseur};

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau[] fregates = {fregate};

        Vaisseau cargo1 = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo1.nbPassagers = 10000;
        cargo1.blindage = 1520;
        cargo1.resistanceDuBouclier = 20;

        Vaisseau cargo2 = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo2.nbPassagers = 67;
        cargo2.blindage = 509;
        cargo2.resistanceDuBouclier = 57;

        Vaisseau[] cargos = {cargo1, cargo2};

        Vaisseau vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        Vaisseau[] vaisseauxMonde = {vaisseauMonde};

        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;
        while (recommencer) {
            System.out.println("Quel vaisseau souhaitez vous manipuler : " + TypeVaisseau.CHASSEUR.name() + ", " + TypeVaisseau.FREGATE.name() + ", " + TypeVaisseau.CROISEUR.name() + ", " + TypeVaisseau.CARGO.name() + " ou " + TypeVaisseau.VAISSEAUMONDE.name() + " ?");
            String typeVaisseauString = sc.nextLine();
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(typeVaisseauString);
            Vaisseau[] vaisseauxSelectionnes = {};

            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseauxSelectionnes = chasseurs;;
                    break;
                case FREGATE:
                    vaisseauxSelectionnes = fregates;
                    break;
                case CROISEUR:
                    vaisseauxSelectionnes = croiseurs;
                    break;
                case CARGO:
                    vaisseauxSelectionnes = cargos;
                    break;
                case VAISSEAUMONDE:
                    vaisseauxSelectionnes = vaisseauxMonde;
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

            int compteurPlacesDisponibles = 0;
            for(Vaisseau v:planeteSelectionnee.vaisseauxAccostes){
                if(v != null) {
                    compteurPlacesDisponibles++;
                }
            }

            if (planeteSelectionnee.restePlaceDisponible() && compteurPlacesDisponibles >= vaisseauxSelectionnes.length) {
                planeteSelectionnee.accueillirVaisseaux(vaisseauxSelectionnes);
                for(Vaisseau vaisseauSelectionne:vaisseauxSelectionnes) {
                    System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
                }
            } else {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
            }

            sc.nextLine();
            System.out.println("Voulez-vous recommencer oui/non ?");

            recommencer = sc.nextLine().equals("oui");

        }
    }

}

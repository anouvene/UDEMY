import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


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

        Set<Planete> planetes = new HashSet();
        planetes.add(mercure);
        planetes.add(venus);
        planetes.add(terre);
        planetes.add(mars);

        planetes.add(jupiter);
        planetes.add(saturne);
        planetes.add(uranus);
        planetes.add(neptune);

        Galaxie galaxie = new Galaxie();
        galaxie.planetes = planetes;

        // Les planetes
        for (Planete p:galaxie.planetes) {
            System.out.println(p.nom);
        }

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

        Vaisseau chasseur2 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur2.nbPassagers = 4;
        chasseur2.blindage = 156;
        chasseur2.resistanceDuBouclier = 2;
        Vaisseau chasseur3 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur3.nbPassagers = 5;
        chasseur3.blindage = 156;
        chasseur3.resistanceDuBouclier = 2;
        Vaisseau cargo2 = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo2.nbPassagers = 10001;
        cargo2.blindage = 1520;
        cargo2.resistanceDuBouclier = 20;
        terre.accueillirVaisseaux(chasseur2,chasseur3,cargo2);

        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;

        while (recommencer) {
            System.out.println("Quel vaisseau souhaitez vous manipuler : " + TypeVaisseau.CHASSEUR.name() + ", " + TypeVaisseau.FREGATE.name() + ", " + TypeVaisseau.CROISEUR.name() + ", " + TypeVaisseau.CARGO.name() + " ou " + TypeVaisseau.VAISSEAUMONDE.name() + " ?");
            String typeVaisseauString = sc.nextLine();
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(typeVaisseauString);
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

            System.out.println("Choisir une planète tellurique dans la galaxie du plus proche au plus éloignée du système solaire pour votre vaisseau : " +
                    "Mercure, Venus, Terre, Mars, Jupiter, Saturne, Uranus, Neptune ?");

            String nomPlanete = sc.nextLine();
            Planete planete = null;
            Iterator<Planete> iter = galaxie.planetes.iterator();
            while (iter.hasNext()) {
                Planete p = iter.next();
                if(p.nom.equalsIgnoreCase(nomPlanete)) {
                    planete = p;
                    break;
                }
            }

            if(planete == null || planete instanceof PlaneteGazeuse) {
                System.out.println("la planète choisie n'est pas une planète tellurique, veuiller recommencer");
                continue;
            }

            PlaneteTellurique planeteSelectionnee = (PlaneteTellurique)planete;

            System.out.println("Quel tonnage souhaitez-vous emporter ?");
            int tonnageSouhaite = sc.nextInt();

            if (planeteSelectionnee.restePlaceDisponible(vaisseauSelectionne.type)) {
                planeteSelectionnee.accueillirVaisseaux(vaisseauSelectionne);
                System.out.println("Le vaisseau a rejeté : " + vaisseauSelectionne.emporterCargaison(tonnageSouhaite) + " tonnes.");
            } else {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
            }

            sc.nextLine();
            System.out.println("Voulez-vous recommencer oui/non ?");

            recommencer = sc.nextLine().equals("oui");

        }

    }

}


public class HelloUniverse {

    public static void main(String... args) {

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
        mercure.diametre = 4880;
        mercure.matiere = "Tellurique";

        PlaneteTellurique venus = new PlaneteTellurique("Venus");
        venus.diametre = 12100;
        venus.matiere = "Tellurique";

        PlaneteTellurique terre = new PlaneteTellurique("Terre");
        terre.diametre = 12756;
        terre.matiere = "Tellurique";

        PlaneteTellurique mars = new PlaneteTellurique("Mars");
        mars.diametre = 6792;
        mars.matiere = "Tellurique";

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.matiere = "Gazeuse";

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.matiere = "Gazeuse";

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.matiere = "Gazeuse";

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.matiere = "Gazeuse";

        Vaisseau chasseur = new VaisseauDeGuerre("CHASSEUR");
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau vaisseauMonde = new VaisseauCivil("VAISSEAU-MONDE");
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        chasseur.activerBouclier();
        vaisseauMonde.activerBouclier();

        ((VaisseauDeGuerre)chasseur).attaque(vaisseauMonde, "Lasers photoniques", 3);
        vaisseauMonde.desactiverBouclier();

        System.out.println("La durée de protection résiduelle du bouclier du " + vaisseauMonde.type + " est: "
                + vaisseauMonde.resistanceDuBouclier);

        System.out.println("La valeur du blindage du " + vaisseauMonde.type + " est: " + vaisseauMonde.blindage);

        // Accueillir vaissau-monde sur mars
        mars.accueillirVaisseau(vaisseauMonde);

        // Accueillir chasseur sur jupiter
        //jupiter.accueillirVaisseau(vaisseauMonde);

        // Accueillir chasseur sur mars
        mars.accueillirVaisseau(chasseur);

    }

}

public class PlaneteTellurique extends Planete implements Habitable{

    Vaisseau[][] vaisseauxAccostes;
    int totalVisiteurs;

    public PlaneteTellurique(String nom, int nbPlacesBaie) {
        super(nom);
        vaisseauxAccostes = new Vaisseau[2][nbPlacesBaie];
    }

    boolean restePlaceDisponible() {
        for (int i=0 ; i<vaisseauxAccostes.length ; i++) {
            for (int j = 0; j < vaisseauxAccostes[i].length; j++) {
                if (vaisseauxAccostes[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void accueillirVaisseaux(Vaisseau... nouveauxVaisseaux){

        for(Vaisseau nouveauVaisseau: nouveauxVaisseaux) {
            for (int i=0 ; i<vaisseauxAccostes.length ; i++) {
                for (int j=0; j < vaisseauxAccostes[i].length; j++)
                if (vaisseauxAccostes[i][j] == null) {
                    vaisseauxAccostes[i][j] = nouveauVaisseau;
                    break;
                }
            }

            if (nouveauVaisseau instanceof VaisseauDeGuerre) {
                ((VaisseauDeGuerre) nouveauVaisseau).desactiverArmes();
                totalVisiteurs += nouveauVaisseau.nbPassagers;
            }
        }

    }
}

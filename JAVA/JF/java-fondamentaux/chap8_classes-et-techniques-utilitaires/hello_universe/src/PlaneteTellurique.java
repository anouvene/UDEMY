public class PlaneteTellurique extends Planete implements Habitable{

    Vaisseau[] vaisseauxAccostes;
    int totalVisiteurs;

    public PlaneteTellurique(String nom, int nbPlacesBaie) {
        super(nom);
        vaisseauxAccostes=new Vaisseau[nbPlacesBaie];
    }

    boolean restePlaceDisponible() {
        for (int i=0 ; i<vaisseauxAccostes.length ; i++){
            if (vaisseauxAccostes[i]==null){
                return true;
            }
        }
        return false;
    }

    public void accueillirVaisseaux(Vaisseau... nouveauxVaisseaux){

        for(Vaisseau nouveauVaisseau: nouveauxVaisseaux) {
            for (int i=0 ; i<vaisseauxAccostes.length ; i++) {
                if (vaisseauxAccostes[i] == null) {
                    vaisseauxAccostes[i] = nouveauVaisseau;
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

public class PlaneteTellurique extends Planete implements Habitable {

    Vaisseau[][] vaisseauxAccostes;
    int totalVisiteurs;

    public PlaneteTellurique(String nom, int nbPlacesBaie) {
        super(nom);
        vaisseauxAccostes = new Vaisseau[2][nbPlacesBaie];
    }

    boolean restePlaceDisponible(TypeVaisseau typeVaisseau) {
        int zoneIndice = 0;

        // Passer directement à la ligne 1 du tableau et vérifier les places restantes des vaisseaux civiles
        if(typeVaisseau.nom.equals(TypeVaisseau.VAISSEAUMONDE.nom) || typeVaisseau.nom.equals(TypeVaisseau.CARGO.nom)) {
            zoneIndice = 1;
        }

        // Vérifier les places restantes
        for (int j=0; j<vaisseauxAccostes[zoneIndice].length; j++) {
            if (vaisseauxAccostes[zoneIndice][j] == null) {
                return true;
            }
        }

        return false;
    }

    public void accueillirVaisseaux(Vaisseau... nouveauxVaisseaux) {

        for(Vaisseau nouveauVaisseau: nouveauxVaisseaux) {
            int zoneIndice = 0;

            // Passer directement à la ligne 1 du tableau et vérifier les places restantes des vaisseaux civiles
            if(nouveauVaisseau.type.equals(TypeVaisseau.VAISSEAUMONDE) || nouveauVaisseau.type.equals(TypeVaisseau.CARGO)) {
                zoneIndice = 1;
            }

            for (int j=0; j < vaisseauxAccostes[zoneIndice].length; j++) {
                if (vaisseauxAccostes[zoneIndice][j] == null) {
                    vaisseauxAccostes[zoneIndice][j] = nouveauVaisseau;
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

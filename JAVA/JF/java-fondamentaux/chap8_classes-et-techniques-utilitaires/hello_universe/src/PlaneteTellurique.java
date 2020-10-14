
public class PlaneteTellurique extends Planete implements Habitable{

    Vaisseau[] vaisseauxAccostes;
    int totalVisiteurs;

    int tailleBaie;
    int compteurVaisseau = 0;

    public PlaneteTellurique(String nom, int tailleBaie) {
        super(nom);
        this.tailleBaie = tailleBaie;
        this.vaisseauxAccostes = new Vaisseau[tailleBaie];
    }

    public Vaisseau accueillirVaisseau(Vaisseau nouveauVaisseau){
        compteurVaisseau++;

        if (nouveauVaisseau instanceof VaisseauDeGuerre){
            ((VaisseauDeGuerre)nouveauVaisseau).desactiverArmes();
        }

        totalVisiteurs += nouveauVaisseau.nbPassagers;

        Vaisseau vaisseauPrecedent = vaisseauxAccostes[compteurVaisseau-1];
        vaisseauxAccostes[compteurVaisseau-1] = nouveauVaisseau;

        return vaisseauPrecedent;

    }

    public boolean restePlaceDisponible() {
        boolean flag = false;

        for(Vaisseau v:vaisseauxAccostes) {
            if(v == null) {
                flag = true;
            }
        }

        return flag;
    }
}

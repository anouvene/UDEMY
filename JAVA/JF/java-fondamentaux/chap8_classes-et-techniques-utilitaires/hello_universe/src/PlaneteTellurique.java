public class PlaneteTellurique extends Planete implements Habitable {
    int totalVisiteurs;
    Vaisseau vaisseauAccoste;

    public PlaneteTellurique(String nom) {
        super(nom);
    }

    @Override
    public Vaisseau accueillirVaisseau(Vaisseau nouveauVaisseau) {
        if(nouveauVaisseau instanceof VaisseauDeGuerre) {
            ((VaisseauDeGuerre)nouveauVaisseau).desactiverArmes();
        }

        totalVisiteurs+=nouveauVaisseau.nbPassagers;
        Vaisseau vaisseauPrecedent=vaisseauAccoste;
        vaisseauAccoste=nouveauVaisseau;

        return vaisseauPrecedent;
    }
}

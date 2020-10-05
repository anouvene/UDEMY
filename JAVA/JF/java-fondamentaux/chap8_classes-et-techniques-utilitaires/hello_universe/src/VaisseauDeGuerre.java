public class VaisseauDeGuerre extends Vaisseau {
    boolean armesDesactivees = false;

    public VaisseauDeGuerre(String type) {
        super(type);
        switch(type.toLowerCase()) {
            case "chasseur":
                super.tonnageMax = 0;
                break;
            case "frégate":
                super.tonnageMax = 50;
                break;
            case "croiseur":
                super.tonnageMax = 100;
                break;
        }
    }

    void attaque(Vaisseau vaisseauCible, String armeUtilise, int dureeAttaque) {
        if(this.armesDesactivees) {
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + super.type + " attaque un vaisseau de type " + vaisseauCible.type
                    + " en utilisant l'arme " + armeUtilise  + " pendant " + dureeAttaque  + " minutes.");
            vaisseauCible.resistanceDuBouclier = 0;
            vaisseauCible.blindage /= 2;
        }
    }

    void desactiverArmes() {
        this.armesDesactivees = true;
        System.out.println("Désactivation des armes d'un vaisseau de type " + super.type);
    }

    @Override
    void activerBouclier() {
        super.activerBouclier();
        this.desactiverArmes();
    }

    @Override
    int emporterCargaison(int tonnage) {
        return 0;
    }
}

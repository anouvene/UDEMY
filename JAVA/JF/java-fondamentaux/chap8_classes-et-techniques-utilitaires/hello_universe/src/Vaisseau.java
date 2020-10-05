public abstract class Vaisseau {

    int nbPassagers;
    String type;
    int blindage;
    int resistanceDuBouclier;

    int tonnageMax;
    int tonnageActuel;

    public Vaisseau(String type) {
        this.type = type;
    }

    void activerBouclier() {
        System.out.println("Activation du bouclier d'un vaisseau de type " + this.type);
    }

    void desactiverBouclier() {
        System.out.println("Désactivation du bouclier d'un vaisseau de type " + this.type);
    }

    abstract int emporterCargaison(int tonnage);

}

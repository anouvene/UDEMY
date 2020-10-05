public class VaisseauCivil extends Vaisseau {

    public VaisseauCivil(String type) {
        this.type = type;
        if (type.equals("CARGO")) {
            tonnageMax = 500;
        } else if (type.equals("VAISSEAU-MONDE")) {
            tonnageMax = 2000;
        }

    }

    int emporterCargaison(int tonnage) {

        int tonnageRestant = tonnageMax - tonnageActuel;
        if (tonnage > tonnageRestant) {
            tonnageActuel = tonnageMax;
            return tonnage-tonnageRestant;
        }
        tonnageActuel+=tonnage;
        return 0;
    }

}

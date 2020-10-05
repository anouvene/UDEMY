public class VaisseauCivil extends Vaisseau {

    public VaisseauCivil(String type) {
        super(type);
        switch(type.toLowerCase()) {
            case "cargo":
                super.tonnageMax = 500;
                break;
            case "vaisseau=monde":
                super.tonnageMax = 2000;
                break;
        }

    }

    @Override
    int emporterCargaison(int tonnage) {
        return 0;
    }
}

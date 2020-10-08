public enum TypeVaisseau {
    CHASSEUR("Chasseur"),
    FREGATE("Frégate"),
    CROISEUR("Croiseur"),
    CARGO("Cargo"),
    VAISSEAUMONDE("Vaisseau-Monde");

    public String nom;

    private TypeVaisseau(String nom) {
        this.nom = nom;
    }

}

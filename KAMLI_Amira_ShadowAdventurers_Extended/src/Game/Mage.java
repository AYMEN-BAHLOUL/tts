falspackage Game;

// Classe représentant un mage, une sous-classe de Personnage.
class Mage extends Personnage {
    // Constructeur pour initialiser le mage.
    public Mage(String nom) {
        // super(nom, 80, 15); // Définit 80 PV et 15 dégâts de base.
        super(nom, 80, 15, 50); // EXTENSION: Ajout de l'énergie initiale (50).
    }

    // @Override
    // // Méthode pour attaquer un adversaire.
    // public void attaquer(Personnage cible) {
    //     System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
    //     cible.recevoirDegats(degats);
    // }

    @Override
    // Méthode pour attaquer un adversaire.
    public void attaquer(Personnage cible) {
        int totalDegats = degats;

        // EXTENSION: Coup critique avec une chance normale (10%).
        if (estCritique()) {
            totalDegats *= 2;
            System.out.println(nom + " inflige un coup critique magique !");
        }

        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(totalDegats);
    }

    // @Override
    // // Méthode pour utiliser une compétence spéciale.
    // public void utiliserCompetence(Personnage cible) {
    //     System.out.println(nom + " invoque une tempête magique !");
    //     cible.recevoirDegats(degats + 10); // Ajoute 10 dégâts supplémentaires.
    // }

    @Override
    // Méthode pour utiliser une compétence spéciale.
    public void utiliserCompetence(Personnage cible) {
        // EXTENSION: La compétence consomme de l'énergie.
        if (utiliserEnergie(20)) {
            System.out.println(nom + " invoque une tempête magique !");
            cible.recevoirDegats(degats + 10); // Inflige 10 dégâts supplémentaires.
        } else {
            System.out.println(nom + " n'a pas assez d'énergie pour invoquer une tempête magique !");
        }
    }

    // EXTENSION: Nouvelle méthode pour régénérer de l'énergie chaque tour.
    public void regenererEnergie() {
        energie += 5; // Récupère 5 points d'énergie par tour.
        System.out.println(nom + " régénère 5 points d'énergie. Énergie actuelle : " + energie);
    }
}

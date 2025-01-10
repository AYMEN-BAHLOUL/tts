package Game;

// Classe représentant un guerrier, une sous-classe de Personnage.
class Guerrier extends Personnage {
    // Constructeur pour initialiser le guerrier.
    public Guerrier(String nom) {
        // super(nom, 100, 10); // Définit 100 PV (Points de Vie) et 10 dégâts de base.
        super(nom, 100, 10, 50); // EXTENSION: Ajout de l'énergie initiale (50).
    }

    // @Override
    // // Méthode pour attaquer un adversaire.
    // public void attaquer(Personnage cible) {
    //     System.out.println(nom + " attaque " + cible.getNom() + " !");
    //     cible.recevoirDegats(degats);
    // }

    @Override
    // Méthode pour attaquer un adversaire.
    public void attaquer(Personnage cible) {
        int totalDegats = degats;
        if (estCritique()) { // EXTENSION: Gestion des coups critiques.
            totalDegats *= 2;
            System.out.println(nom + " inflige un coup critique !");
        }
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(totalDegats);
    }

    // @Override
    // // Méthode pour utiliser une compétence spéciale.
    // public void utiliserCompetence(Personnage cible) {
    //     System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
    //     cible.recevoirDegats(degats * 2); // Dégâts doublés pour cette attaque.
    // }

    @Override
    // Méthode pour utiliser une compétence spéciale.
    public void utiliserCompetence(Personnage cible) {
        if (utiliserEnergie(20)) { // EXTENSION: Consomme de l'énergie pour la compétence.
            System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
            cible.recevoirDegats(degats * 2);
        }
    }
}

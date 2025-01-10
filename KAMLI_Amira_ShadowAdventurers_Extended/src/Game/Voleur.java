package Game;

// Classe représentant un voleur, une sous-classe de Personnage.
class Voleur extends Personnage {
    // Constructeur pour initialiser le voleur.
    public Voleur(String nom) {
        // super(nom, 70, 12); // Définit 70 PV et 12 dégâts de base.
        super(nom, 70, 12, 40); // EXTENSION: Ajout de l'énergie initiale (40).
    }

    // @Override
    // // Méthode pour attaquer un adversaire.
    // public void attaquer(Personnage cible) {
    //     System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
    //     cible.recevoirDegats(degats);

    //     // Probabilité d'infliger un coup critique (20%).
    //     if (Math.random() < 0.2) {
    //         System.out.println(nom + " inflige un coup critique !");
    //         cible.recevoirDegats(degats); // Inflige des dégâts supplémentaires.
    //     }
    // }

    @Override
    // Méthode pour attaquer un adversaire.
    public void attaquer(Personnage cible) {
        int totalDegats = degats;

        // Probabilité d'infliger un coup critique (20%).
        // EXTENSION: Coup critique avec une chance plus élevée (20%).
        if (Math.random() < 0.2) {
            totalDegats *= 2;
            System.out.println(nom + " inflige un coup critique !");
        }

        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
        cible.recevoirDegats(totalDegats); // Inflige des dégâts supplémentaires.
    }

    // @Override
    // // Méthode pour utiliser une compétence spéciale.
    // public void utiliserCompetence(Personnage cible) {
    //     System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
    //     cible.recevoirDegats(degats * 3); // Dégâts triplés pour cette attaque.
    // }

    @Override
    // Méthode pour utiliser une compétence spéciale.
    public void utiliserCompetence(Personnage cible) {
        // EXTENSION: La compétence consomme de l'énergie.
        if (utiliserEnergie(15)) {
            System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
            cible.recevoirDegats(degats * 3); // Inflige des dégâts triplés.
        } else {
            System.out.println(nom + " n'a pas assez d'énergie pour utiliser Attaque rapide !");
        }
    }
}

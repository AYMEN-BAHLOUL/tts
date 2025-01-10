package Game;

// EXTENSION: Nouvelle classe Cleric, une sous-classe de Personnage.
class Cleric extends Personnage {
    public Cleric(String nom) {
        super(nom, 90, 8, 60); // 90 PV (Points de Vie), 8 dégâts, 60 énergie initiale.
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        if (utiliserEnergie(15)) {
            System.out.println(nom + " utilise sa compétence spéciale : Soin !");
            pointsDeVie += 20; // Le Cleric récupère 20 points de vie.
            System.out.println(nom + " récupère 20 points de vie. Points de vie actuels : " + pointsDeVie);
        }
    }
}

package Game;

// Classe abstraite représentant un personnage dans le jeu.
abstract class Personnage implements Attaquable {
    protected String nom; // Nom du personnage.
    protected int pointsDeVie; // Points de vie du personnage.
    protected int degats; // Dégâts de base infligés par le personnage.
    protected int niveau; // Niveau actuel du personnage.
    protected int experience; // Points d'expérience accumulés.

    // EXTENSION: Ajout de la variable énergie.
    protected int energie; 

    // EXTENSION: Mise à jour du constructeur pour inclure l'énergie.
    public Personnage(String nom, int pointsDeVie, int degats, int energie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.degats = degats;
        this.energie = energie; // Initialisation de l'énergie.
        this.niveau = 1;
        this.experience = 0;
    }

    public void recevoirDegats(int degats) {
        pointsDeVie -= degats;
        System.out.println(nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + pointsDeVie);
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    public String getNom() {
        return nom;
    }

    public void gagnerExperience(int xp) {
        experience += xp;
        if (experience >= 100) {
            niveau++;
            experience = 0;
            System.out.println(nom + " a atteint le niveau " + niveau + " !");
        }
    }

    // EXTENSION: Méthode pour utiliser l'énergie.
    public boolean utiliserEnergie(int cout) {
        if (energie >= cout) {
            energie -= cout;
            System.out.println(nom + " a utilisé " + cout + " points d'énergie. Énergie restante : " + energie);
            return true;
        } else {
            System.out.println(nom + " n'a pas assez d'énergie !");
            return false;
        }
    }

    // EXTENSION: Méthode pour vérifier un coup critique.
    public boolean estCritique() {
        return Math.random() < 0.1; // 10% de chances de coup critique.
    }

    // EXTENSION: Méthode par défaut pour régénérer de l'énergie (peut être redéfinie dans les sous-classes).
    public void regenererEnergie() {
        // Par défaut, les personnages ne régénèrent pas d'énergie.
    }
}

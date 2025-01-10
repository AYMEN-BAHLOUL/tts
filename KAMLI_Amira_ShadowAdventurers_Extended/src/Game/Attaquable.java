package Game;

// Interface définissant les comportements pour attaquer et utiliser une compétence spéciale.
public interface Attaquable {
    // Méthode pour attaquer un adversaire.
	void attaquer(Personnage cible);

    // Méthode pour utiliser une compétence spéciale contre un adversaire.
	void utiliserCompetence(Personnage cible);
}

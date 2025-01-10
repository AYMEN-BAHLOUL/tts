package Game;

// Test case for character leveling up.
public class TestLevelUp {
    public static void main(String[] args) {
        Personnage guerrier = new Guerrier("Thor");

        System.out.println("Niveau avant expérience:");
        System.out.println(guerrier.getNom() + " - Niveau: " + guerrier.niveau);

        guerrier.gagnerExperience(50);
        guerrier.gagnerExperience(50); // Gagne un total de 100 points d'expérience.

        System.out.println("Niveau après expérience:");
        System.out.println(guerrier.getNom() + " - Niveau: " + guerrier.niveau);
    }
}

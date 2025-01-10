package Game;

// Test case for character special ability.
public class TestSpecialAbility {
    public static void main(String[] args) {
        Personnage voleur = new Voleur("Loki");
        Personnage mage = new Mage("Gandalf");

        System.out.println("Énergie avant la compétence:");
        System.out.println(voleur.getNom() + " - Énergie: " + voleur.energie);

        voleur.utiliserCompetence(mage);

        System.out.println("Énergie après la compétence:");
        System.out.println(voleur.getNom() + " - Énergie: " + voleur.energie);
    }
}

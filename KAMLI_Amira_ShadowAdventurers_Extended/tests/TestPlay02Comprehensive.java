package Game;

public class TestPlay02Comprehensive {
    public static void main(String[] args) {
        // Initialize characters with expected attributes.
        Personnage guerrier = new Guerrier("Thor");   // 100 PV, 10 dégâts, 50 énergie.
        Personnage mage = new Mage("Gandalf");        // 80 PV, 15 dégâts, 50 énergie.
        Personnage voleur = new Voleur("Loki");       // 70 PV, 12 dégâts, 40 énergie.
        Personnage cleric = new Cleric("Eowyn");      // 90 PV, 8 dégâts, 60 énergie.

        // Initial State Check
        System.out.println("### Initial State ###");
        printCharacterState(guerrier);
        printCharacterState(mage);
        printCharacterState(voleur);
        printCharacterState(cleric);

        // Turn 1: Guerrier attacks Mage
        System.out.println("\n### Turn 1: Guerrier attacks Mage ###");
        guerrier.attaquer(mage);
        printCharacterState(mage);

        // Turn 2: Mage uses special skill on Guerrier
        System.out.println("\n### Turn 2: Mage uses special skill on Guerrier ###");
        mage.utiliserCompetence(guerrier);
        printCharacterState(guerrier);
        printCharacterState(mage); // Check Mage energy after skill use.

        // Turn 3: Voleur attacks Cleric
        System.out.println("\n### Turn 3: Voleur attacks Cleric ###");
        voleur.attaquer(cleric);
        printCharacterState(cleric);

        // Turn 4: Cleric heals itself
        System.out.println("\n### Turn 4: Cleric heals itself ###");
        cleric.utiliserCompetence(cleric);
        printCharacterState(cleric);

        // Turn 5: Guerrier uses special skill on Voleur
        System.out.println("\n### Turn 5: Guerrier uses special skill on Voleur ###");
        guerrier.utiliserCompetence(voleur);
        printCharacterState(voleur);
        printCharacterState(guerrier); // Check Guerrier energy after skill use.

        // Turn 6: Mage regenerates energy and attacks
        System.out.println("\n### Turn 6: Mage regenerates energy and attacks ###");
        mage.regenererEnergie(); // Regenerate energy (Mage-specific).
        mage.attaquer(voleur);
        printCharacterState(voleur);
        printCharacterState(mage);

        // Turn 7: Voleur uses special skill on Cleric
        System.out.println("\n### Turn 7: Voleur uses special skill on Cleric ###");
        voleur.utiliserCompetence(cleric);
        printCharacterState(cleric);
        printCharacterState(voleur);

        // Final State Check
        System.out.println("\n### Final State ###");
        printCharacterState(guerrier);
        printCharacterState(mage);
        printCharacterState(voleur);
        printCharacterState(cleric);
    }

    // Helper function to print the state of a character
    private static void printCharacterState(Personnage personnage) {
        System.out.println(personnage.getNom() + " - PV: " + personnage.pointsDeVie 
                           + ", Dégâts: " + personnage.degats 
                           + ", Énergie: " + personnage.energie);
    }
}

package Game;

// Test case for full combat simulation.
public class TestCombatSimulation {
    public static void main(String[] args) {
        // Initialize characters
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");
        Personnage cleric = new Cleric("Eowyn");

        // Initial state
        System.out.println("### Initial State ###");
        printCharacterState(guerrier);
        printCharacterState(mage);
        printCharacterState(voleur);
        printCharacterState(cleric);

        // Combat simulation loop
        System.out.println("\n### Combat Simulation ###");
        int turn = 1;

        while (isAnyCharacterAlive(guerrier, mage, voleur, cleric)) {
            System.out.println("\n--- Turn " + turn + " ---");

            // Each character takes their turn if alive
            if (guerrier.estVivant()) {
                System.out.println(guerrier.getNom() + " attaque !");
                guerrier.attaquer(mage); // Guerrier attacks Mage
                printCharacterState(mage);
                if (!mage.estVivant()) {
                    System.out.println(mage.getNom() + " est vaincu !");
                    break;
                }
            }

            if (mage.estVivant()) {
                System.out.println(mage.getNom() + " utilise Tempête magique !");
                mage.utiliserCompetence(guerrier); // Mage uses Tempête magique on Guerrier
                printCharacterState(guerrier);
                printCharacterState(mage);
                if (!guerrier.estVivant()) {
                    System.out.println(guerrier.getNom() + " est vaincu !");
                    break;
                }
            }

            if (voleur.estVivant()) {
                System.out.println(voleur.getNom() + " utilise Attaque rapide !");
                voleur.utiliserCompetence(cleric); // Voleur attacks Cleric
                printCharacterState(cleric);
                printCharacterState(voleur);
                if (!cleric.estVivant()) {
                    System.out.println(cleric.getNom() + " est vaincu !");
                    break;
                }
            }

            if (cleric.estVivant()) {
                System.out.println(cleric.getNom() + " utilise Soin !");
                cleric.utiliserCompetence(cleric); // Cleric heals itself
                printCharacterState(cleric);
            }

            // Optional: Regenerate energy for Mage after each round
            if (mage.estVivant()) {
                mage.regenererEnergie();
                printCharacterState(mage);
            }

            turn++;
        }

        // Determine and display the winner
        System.out.println("\n### Winner ###");
        if (guerrier.estVivant()) {
            System.out.println("The winner is " + guerrier.getNom() + "!");
        } else if (mage.estVivant()) {
            System.out.println("The winner is " + mage.getNom() + "!");
        } else if (voleur.estVivant()) {
            System.out.println("The winner is " + voleur.getNom() + "!");
        } else if (cleric.estVivant()) {
            System.out.println("The winner is " + cleric.getNom() + "!");
        } else {
            System.out.println("All characters have been defeated. It's a draw!");
        }
    }

    // Helper function to print the state of a character
    private static void printCharacterState(Personnage personnage) {
        System.out.println(personnage.getNom() + " - PV: " + personnage.pointsDeVie 
                           + ", Dégâts: " + personnage.degats 
                           + ", Énergie: " + personnage.energie);
    }

    // Helper function to check if at least one character is alive
    private static boolean isAnyCharacterAlive(Personnage... personnages) {
        for (Personnage p : personnages) {
            if (p.estVivant()) {
                return true;
            }
        }
        return false;
    }
}

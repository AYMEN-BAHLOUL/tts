package Game;

import java.util.Scanner;

// Classe principale pour simuler un combat automatisé entre les personnages.
public class Play {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Création des instances des personnages.
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");

        // Boucle de combat tant que tous les personnages sont vivants.
        while (guerrier.estVivant() && mage.estVivant() && voleur.estVivant()) {
            System.out.println("\n--- Tour de combat ---");
            
            // Le guerrier attaque le mage.
            guerrier.attaquer(mage);
            mage.gagnerExperience(10); // Le mage gagne de l'expérience.
            if (!mage.estVivant()) { // Vérifie si le mage est vaincu.
                System.out.println(mage.getNom() + " est vaincu !");
                break;
            }

            // Le mage attaque le guerrier.
            mage.attaquer(guerrier);
            guerrier.gagnerExperience(10); // Le guerrier gagne de l'expérience.
            if (!guerrier.estVivant()) { // Vérifie si le guerrier est vaincu.
                System.out.println(guerrier.getNom() + " est vaincu !");
                break;
            }

            // Le voleur attaque le mage.
            voleur.attaquer(mage);
            voleur.gagnerExperience(10); // Le voleur gagne de l'expérience.
            if (!mage.estVivant()) { // Vérifie si le mage est vaincu.
                System.out.println(mage.getNom() + " est vaincu !");
                break;
            }

            // Le voleur utilise sa compétence spéciale sur le guerrier.
            voleur.utiliserCompetence(guerrier);
            if (!guerrier.estVivant()) { // Vérifie si le guerrier est vaincu.
                System.out.println(guerrier.getNom() + " est vaincu !");
                break;
            }
        }
        
        scanner.close(); // Fermeture du scanner pour libérer les ressources.
    }
}

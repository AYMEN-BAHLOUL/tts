package Game;

import java.util.Scanner;

// Classe principale pour un combat interactif où le joueur choisit son personnage et ses actions.
public class Play02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création des instances des personnages, y compris la nouvelle classe Cleric.
        // EXTENSION: Ajout du Cleric et mise à jour des énergies initiales.
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");
        Personnage cleric = new Cleric("Eowyn");

        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Voleur");
        System.out.println("4. Cleric"); // EXTENSION: Ajout du Cleric comme option.

        int choix = scanner.nextInt();
        Personnage joueur;

        // Assignation du personnage sélectionné par l'utilisateur.
        switch (choix) {
            case 1: 
                joueur = guerrier; 
                break;
            case 2: 
                joueur = mage; 
                break;
            case 3: 
                joueur = voleur; 
                break;
            case 4: 
                joueur = cleric; 
                break;
            default:
                System.out.println("Choix invalide. Guerrier sélectionné par défaut.");
                joueur = guerrier;
        }

        // Boucle principale du combat.
        while (joueur.estVivant() && (guerrier.estVivant() || mage.estVivant() || voleur.estVivant() || cleric.estVivant())) {
            System.out.println("\n--- Tour de combat ---");

            // EXTENSION: Présentation des actions mises à jour, y compris la défense.
            System.out.println("Choisissez une action :");
            System.out.println("1. Attaquer un adversaire");
            System.out.println("2. Utiliser une compétence spéciale");
            System.out.println("3. Défendre (réduit les dégâts subis au prochain tour)");
            System.out.println("4. Passer son tour");

            int action = scanner.nextInt();

            // Gestion des actions choisies par le joueur.
            switch (action) {
                case 1: // Attaquer un adversaire.
                    System.out.println("Choisissez un adversaire :");
                    if (guerrier.estVivant()) System.out.println("1. " + guerrier.getNom());
                    if (mage.estVivant()) System.out.println("2. " + mage.getNom());
                    if (voleur.estVivant()) System.out.println("3. " + voleur.getNom());
                    if (cleric.estVivant()) System.out.println("4. " + cleric.getNom());

                    int cible = scanner.nextInt();

                    switch (cible) {
                        case 1:
                            if (guerrier.estVivant()) joueur.attaquer(guerrier);
                            else System.out.println("Thor est déjà vaincu !");
                            break;
                        case 2:
                            if (mage.estVivant()) joueur.attaquer(mage);
                            else System.out.println("Gandalf est déjà vaincu !");
                            break;
                        case 3:
                            if (voleur.estVivant()) joueur.attaquer(voleur);
                            else System.out.println("Loki est déjà vaincu !");
                            break;
                        case 4:
                            if (cleric.estVivant()) joueur.attaquer(cleric);
                            else System.out.println("Eowyn est déjà vaincu !");
                            break;
                        default:
                            System.out.println("Cible invalide !");
                    }
                    break;

                case 2: // Utiliser une compétence spéciale.
                    System.out.println("Choisissez un adversaire :");
                    if (guerrier.estVivant()) System.out.println("1. " + guerrier.getNom());
                    if (mage.estVivant()) System.out.println("2. " + mage.getNom());
                    if (voleur.estVivant()) System.out.println("3. " + voleur.getNom());
                    if (cleric.estVivant()) System.out.println("4. " + cleric.getNom());

                    cible = scanner.nextInt();

                    switch (cible) {
                        case 1:
                            if (guerrier.estVivant()) joueur.utiliserCompetence(guerrier);
                            else System.out.println("Thor est déjà vaincu !");
                            break;
                        case 2:
                            if (mage.estVivant()) joueur.utiliserCompetence(mage);
                            else System.out.println("Gandalf est déjà vaincu !");
                            break;
                        case 3:
                            if (voleur.estVivant()) joueur.utiliserCompetence(voleur);
                            else System.out.println("Loki est déjà vaincu !");
                            break;
                        case 4:
                            if (cleric.estVivant()) joueur.utiliserCompetence(cleric);
                            else System.out.println("Eowyn est déjà vaincu !");
                            break;
                        default:
                            System.out.println("Cible invalide !");
                    }
                    break;

                case 3: // EXTENSION: Défense.
                    System.out.println(joueur.getNom() + " se prépare à se défendre au prochain tour !");
                    // Cette action peut réduire les dégâts subis dans les tours suivants.
                    break;

                case 4: // Passer le tour.
                    System.out.println(joueur.getNom() + " passe son tour.");
                    break;

                default:
                    System.out.println("Action invalide !");
            }

            // EXTENSION: Ajout des actions automatiques pour les adversaires vivants.
            if (guerrier.estVivant()) guerrier.attaquer(joueur);
            if (mage.estVivant()) {
                mage.regenererEnergie(); // EXTENSION: Régénération d'énergie pour le Mage.
                mage.attaquer(joueur);
            }
            if (voleur.estVivant()) voleur.attaquer(joueur);
            if (cleric.estVivant()) cleric.utiliserCompetence(cleric); // EXTENSION: Le Cleric peut se soigner.

            // Vérification de la survie du joueur.
            if (!joueur.estVivant()) {
                System.out.println(joueur.getNom() + " est vaincu !");
                break;
            }

            if (mage.estVivant()) {
                ((Mage) mage).regenererEnergie(); // Cast mage pour accéder à la méthode spécifique.
                mage.attaquer(joueur);
            }

        }

        System.out.println("Le combat est terminé !");
        scanner.close(); // Fermeture du scanner.
    }
}

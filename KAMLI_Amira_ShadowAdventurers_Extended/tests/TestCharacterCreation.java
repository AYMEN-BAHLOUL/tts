package Game;

// Test case for character creation.
public class TestCharacterCreation {
    public static void main(String[] args) {
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");
        Personnage cleric = new Cleric("Eowyn");

        System.out.println("Test de création des personnages:");
        System.out.println(guerrier.getNom() + " - PV: " + guerrier.pointsDeVie + ", Dégâts: " + guerrier.degats);
        System.out.println(mage.getNom() + " - PV: " + mage.pointsDeVie + ", Dégâts: " + mage.degats);
        System.out.println(voleur.getNom() + " - PV: " + voleur.pointsDeVie + ", Dégâts: " + voleur.degats);
        System.out.println(cleric.getNom() + " - PV: " + cleric.pointsDeVie + ", Dégâts: " + cleric.degats);
    }
}

package Game;

// Test case for critical hits.
public class TestCriticalHit {
    public static void main(String[] args) {
        Personnage mage = new Mage("Gandalf");
        Personnage voleur = new Voleur("Loki");

        System.out.println("PV avant l'attaque:");
        System.out.println(mage.getNom() + " - PV: " + mage.pointsDeVie);

        System.out.println("Loki attaque Gandalf...");
        voleur.attaquer(mage); // Vérifier manuellement si un coup critique est signalé.

        System.out.println("PV après l'attaque:");
        System.out.println(mage.getNom() + " - PV: " + mage.pointsDeVie);
    }
}

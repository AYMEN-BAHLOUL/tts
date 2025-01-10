package Game;

// Test case for character attack and damage.
public class TestAttackDamage {
    public static void main(String[] args) {
        Personnage guerrier = new Guerrier("Thor");
        Personnage mage = new Mage("Gandalf");

        System.out.println("PV (Points de Vie) avant l'attaque:");
        System.out.println(mage.getNom() + " - PV: " + mage.pointsDeVie);
م
        guerrier.attaquer(mage);

        System.out.println("PV (Points de Vie) après l'attaque:");
        System.out.println(mage.getNom() + " - PV: " + mage.pointsDeVie);
    }
}

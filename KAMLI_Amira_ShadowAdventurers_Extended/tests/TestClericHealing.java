package Game;

// Test case for Cleric healing ability.
public class TestClericHealing {
    public static void main(String[] args) {
        Personnage cleric = new Cleric("Eowyn");

        System.out.println("PV avant le soin:");
        System.out.println(cleric.getNom() + " - PV: " + cleric.pointsDeVie);

        cleric.utiliserCompetence(cleric);

        System.out.println("PV après le soin:");
        System.out.println(cleric.getNom() + " - PV: " + cleric.pointsDeVie);
    }
}

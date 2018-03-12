package main;

// clasa care genereaza in functie de strategie (transmisa ca parametru) un nou erou

public final class CreateHero {
    private CreateHero() {
    }
    public static Hero createHero(final String heroType) {
        switch (heroType) {
            case "P":
                return new Pyromancer();
            case "K":
                return new Knight();
            case "W":
                return new Wizard();
            case "R":
                return new Rogue();
            default:
                return null;
        }

    }
}

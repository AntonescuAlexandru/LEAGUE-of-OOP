package main;

// clasa ce defineste o celula din harta

public class MapCell {
    private Hero hero1;
    private Hero hero2;
    private String type;

    public MapCell() {
        this.hero1 = null;
        this.hero2 = null;
        this.type = "";
    }

    public MapCell(final String type) {
        this.hero1 = null;
        this.hero2 = null;
        this.type = type;
    }

    public final String getType() {
        return type;
    }

    public final Hero getHero1() {
        return hero1;
    }

    public final Hero getHero2() {
        return hero2;
    }

    public final void setHero1(final Hero hero1) {
        this.hero1 = hero1;
    }

    public final void setHero2(final Hero hero2) {
        this.hero2 = hero2;
    }
}

package main;

// clasa abstracta pentru eroi
// aici am definit campurile si functiile necesare pentru eroi

public abstract class Hero {
    protected AuxiliaryVars auxiliaryVars = new AuxiliaryVars();
    protected String race;
    protected int line;
    protected int column;
    protected float xp;
    protected int level;
    protected float hp;
    protected float maxHp;
    protected float hpPerLevel;
    protected float baseHP;
    protected boolean alive;
    protected String favouriteLand;
    protected float landModifier;
    protected Hero opponent;
    protected boolean onFavouriteLand;
    protected float damageDealt;

    // constructor
    public Hero() {
        onFavouriteLand = false;
        this.level = 0;
        this.xp = 0;
        alive = true;
        damageDealt = 0;
    }

    // prima abilitate a unui erou
    protected abstract void ability1();
    // a doua abilitate a unui erou
    protected abstract void ability2();

    // functie care seteaza hp-ul la level up
    private void lvlUp() {
        maxHp = baseHP + hpPerLevel * level;
        hp = maxHp;
    }

    // functie care seteaza si xp-ul si level-ul pt un erou
    protected final void setXpAndLevel() {
        int oldLevel = level;
        xp = xp + Math.max(0, 200 - (level - opponent.level) * 40);
        if (xp > 250) {
            level = Math.round((xp - 250) / 50) + 1;
            if (level > oldLevel) {
                lvlUp();
            }
        }
    }

    // functie care seteaza oponentul unui erou inaintea unei batalii
    protected final void setOpponent(final Hero opponent) {
        this.opponent = opponent;
    }

    // seteaza un boolean care indica daca eroul se afla pe tipul de teren favorit
    protected final void setFavouriteLandBoolean(final String type) {
        if (favouriteLand.equals(type)) {
            onFavouriteLand = true;
        } else {
            onFavouriteLand = false;
        }
    }

    // aplica modificatorul de teren(daca este cazul) pe dmg-ul unei abilitati
    protected final float applyFavouriteLandModifier(float damage) {
        if (!onFavouriteLand) {
            return damage;
        } else {
            damage = damage * landModifier;
            return damage;
        }
    }

    // aplica DoT la inceputul unei batalii
    protected final void applyDamageOverTime() {
        if (alive) {
            if (auxiliaryVars.getRoundsCounter() > 0) {
                auxiliaryVars.setRoundsCounter(auxiliaryVars.getRoundsCounter() - 1);
                hp = hp - Math.round(auxiliaryVars.getDamageOverTime());
                if (hp < 1) {
                    alive = false;
                }
            }
        }
    }

    // aplica dmg-ul din runda curenta
    protected final void applyCurrentRoundDamage() {
        opponent.hp = opponent.hp - damageDealt;
        if (opponent.hp < 1) {
            opponent.alive = false;
        }
    }


}

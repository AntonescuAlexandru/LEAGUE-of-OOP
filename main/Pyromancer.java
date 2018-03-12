package main;

public class Pyromancer extends Hero {

    // constructor: se seteaza parametrii specifici unui Pyromancer
    public Pyromancer() {
        super();
        hp = Constants.PYROMANCER_BASE_HP;
        race = "Pyromancer";
        favouriteLand = "Volcanic";
        landModifier = LandModifiers.PYROMANCER;
        maxHp = Constants.PYROMANCER_BASE_HP;
        hpPerLevel = Constants.PYROMANCER_LVL_HP;
        baseHP = Constants.PYROMANCER_BASE_HP;
    }

    // implementarea metodei abstracte "ability1"
    @Override
    protected final void ability1() {
        fireblast();
    }

    // implementarea metodei abstracte "ability2"
    @Override
    protected final void ability2() {
        ignite();
    }

    // implementarea abilitatii "fireblast"
    private void fireblast() {
        float damage = Constants.FIREBLAST_BASE_DMG + level * Constants.FIREBLAST_LVL_DMG;
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        auxiliaryVars.setDeflectDamage(damage);
        damage = damage * RaceModifiers.FIREBLAST.get(opponent.race);
        damage = Math.round(damage);
        damageDealt = damage;
    }

    // implementarea abilitatii "ignite"
    private void ignite() {
        float damage = Constants.IGNITE1_BASE_DMG + Constants.IGNITE1_LVL_DMG * level;
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        auxiliaryVars.setDeflectDamage(damage + auxiliaryVars.getDeflectDamage());
        damage = damage * RaceModifiers.IGNITE.get(opponent.race);
        damage = Math.round(damage);

        damageDealt = damageDealt + damage;

        opponent.auxiliaryVars.setRoundsCounter(2);
        damage = Constants.IGNITE2_BASE_DMG + Constants.IGNITE2_LVL_DMG * level;
        damage = damage * RaceModifiers.IGNITE.get(opponent.race);
        damage = Math.round(damage);
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        opponent.auxiliaryVars.setDamageOverTime(damage);
    }


}

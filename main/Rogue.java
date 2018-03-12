package main;

public class Rogue extends Hero {

    // constructor: se seteaza parametrii specifici unui Rogue
    public Rogue() {
        super();
        hp = Constants.ROGUE_BASE_HP;
        race = "Rogue";
        favouriteLand = "Woods";
        landModifier = LandModifiers.ROGUE;
        maxHp = Constants.ROGUE_BASE_HP;
        hpPerLevel = Constants.ROGUE_LVL_HP;
        baseHP = Constants.ROGUE_BASE_HP;
    }

    // implementarea metodei abstracte "ability1"
    @Override
    protected final void ability1() {
        backstab();
    }

    // implementarea metodei abstracte "ability2"
    @Override
    protected final void ability2() {
        paralysis();
    }

    // implementarea abilitatii "backstab"
    private void backstab() {
        float damage = Constants.BACKSTAB_BASE_DMG + Constants.BACKSTAB_LVL_DMG * level;
        damage = Math.round(damage);
        auxiliaryVars.setDeflectDamage(damage);
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        if (auxiliaryVars.getBackstabCriticCounter() % 3 == 0) {
            if (onFavouriteLand) {
                damage = new Float(damage * 1.5);
                damage = Math.round(damage);
                auxiliaryVars.setDeflectDamage(damage);
            }
            auxiliaryVars.setBackstabCriticCounter(auxiliaryVars.getBackstabCriticCounter() + 1);
        } else {
            auxiliaryVars.setBackstabCriticCounter(auxiliaryVars.getBackstabCriticCounter() + 1);
        }
        damage = damage * RaceModifiers.BACKSTAB.get(opponent.race);
        damageDealt = Math.round(damage);
    }

    // implementarea abilitatii "paralysis"
    private void paralysis() {
        float damage = Constants.PARALYSIS_BASE_DMG + Constants.PARALYSIS_LVL_DMG * level;
        damage = Math.round(damage);
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        auxiliaryVars.setDeflectDamage(damage + auxiliaryVars.getDeflectDamage());
        damage = damage * RaceModifiers.PARALYSIS.get(opponent.race);
        damage = Math.round(damage);
        damageDealt = damageDealt + damage;
        opponent.auxiliaryVars.setDamageOverTime(damage);
        opponent.auxiliaryVars.setRooted(true);
        if (onFavouriteLand) {
            opponent.auxiliaryVars.setRoundsCounter(5);
        } else {
            opponent.auxiliaryVars.setRoundsCounter(2);
        }
    }
}

package main;

public class Knight extends Hero {

    // constructor: se seteaza parametrii specifici unui Knight
    public Knight() {
        super();
        hp = Constants.KNIGHT_BASE_HP;
        race = "Knight";
        favouriteLand = "Land";
        landModifier = LandModifiers.KNIGHT;
        maxHp = Constants.KNIGHT_BASE_HP;
        hpPerLevel = Constants.KNIGHT_LVL_HP;
        baseHP = Constants.KNIGHT_BASE_HP;
    }

    // implementarea metodei abstracte "ability1"
    @Override
    protected final void ability1() {
        execute();
    }

    // implementarea metodei abstracte "ability2"
    @Override
    protected final void ability2() {
        slam();
    }


    // implementarea abilitatii "execute"
    private void execute() {
        float damage = Constants.EXECUTE_BASE_DMG + Constants.EXECUTE_LVL_DMG * level;
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        auxiliaryVars.setDeflectDamage(damage);
        damage = damage * RaceModifiers.EXECUTE.get(opponent.race);
        damage = Math.round(damage);
        float percentage = new Float(0.2 + 0.01 * level);
        if (percentage > 0.4) {
            percentage = new Float(0.4);
        }

        if (opponent.hp < percentage * opponent.maxHp) {
            opponent.alive = false;
            damageDealt = opponent.hp;
            opponent.hp = 0;

        } else {
            damageDealt = damage;
        }
    }

    // implementarea abilitatii "slam"
    private void slam() {
        float damage = Constants.SLAM_BASE_DMG + Constants.SLAM_LVL_DMG * level;
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        auxiliaryVars.setDeflectDamage(damage + auxiliaryVars.getDeflectDamage());
        damage = damage * RaceModifiers.SLAM.get(opponent.race);
        damage = Math.round(damage);
        damageDealt = damageDealt + damage;
        opponent.auxiliaryVars.setRooted(true);
        opponent.auxiliaryVars.setRoundsCounter(1);
        opponent.auxiliaryVars.setDamageOverTime(0);
    }
}

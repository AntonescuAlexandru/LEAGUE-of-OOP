package main;

public class Wizard extends Hero {

    // constructor: se seteaza parametrii specifici unui Wizard
    public Wizard() {
        super();
        hp = Constants.WIZARD_BASE_HP;
        race = "Wizard";
        favouriteLand = "Desert";
        landModifier = LandModifiers.WIZARD;
        maxHp = Constants.WIZARD_BASE_HP;
        hpPerLevel = Constants.WIZARD_LVL_HP;
        baseHP = Constants.WIZARD_BASE_HP;
    }

    // implementarea metodei abstracte "ability1"
    @Override
    protected final void ability1() {
        drain();
    }

    // implementarea metodei abstracte "ability2"
    @Override
    protected final void ability2() {
        deflect();
    }

    // implementarea abilitatii "drain"
    private void drain() {
        float percentage = new Float(0.2 + 0.05 * level);
        percentage = percentage * RaceModifiers.DRAIN.get(opponent.race);
        percentage = applyFavouriteLandModifier(percentage);
        damageDealt = percentage * Math.min(new Float(0.3 * opponent.maxHp), opponent.hp);
        damageDealt = Math.round(damageDealt);
    }

    // implementarea abilitatii "deflect"
    private void deflect() {
        float percentage = new Float(0.35 + 0.02 * level);
        if (percentage > 0.7) {
            percentage = new Float(0.7);
        }
        float damage = new Float(percentage * opponent.auxiliaryVars.getDeflectDamage());
        damage = damage * RaceModifiers.DEFLECT.get(opponent.race);
        damage = applyFavouriteLandModifier(damage);
        damage = Math.round(damage);
        damageDealt = damageDealt + damage;
        damageDealt = Math.round(damageDealt);
        opponent.auxiliaryVars.setDeflectDamage(0);
    }
}

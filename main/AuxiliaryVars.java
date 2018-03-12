package main;

// clasa de variabile auxiliare pt DoT, Root, DeflectDmg
// si contorul de critica de la backstab

public class AuxiliaryVars {
    private float damageOverTime;
    private int roundsCounter;
    private boolean isRooted;
    private int backstabCriticCounter;
    private float deflectDamage;

    public AuxiliaryVars() {
        this.damageOverTime = 0;
        this.roundsCounter = 0;
        this.isRooted = false;
        this.backstabCriticCounter = 0;
        this.deflectDamage = 0;
    }

    public final float getDamageOverTime() {
        return damageOverTime;
    }

    public final int getRoundsCounter() {
        return roundsCounter;
    }

    public final boolean isRooted() {
        return isRooted;
    }

    public final int getBackstabCriticCounter() {
        return backstabCriticCounter;
    }

    public final void setDamageOverTime(final float damageOverTime) {
        this.damageOverTime = damageOverTime;
    }

    public final void setRoundsCounter(final int roundsCounter) {
        this.roundsCounter = roundsCounter;
    }

    public final void setRooted(final boolean rooted) {
        isRooted = rooted;
    }

    public final void setBackstabCriticCounter(final int backstabCriticCounter) {
        this.backstabCriticCounter = backstabCriticCounter;
    }

    public final float getDeflectDamage() {
        return deflectDamage;
    }

    public final void setDeflectDamage(final float deflectDamage) {
        this.deflectDamage = deflectDamage;
    }
}

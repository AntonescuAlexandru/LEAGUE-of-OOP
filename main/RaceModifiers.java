package main;

import java.util.HashMap;
import java.util.Map;

// clasa in care retin modificatorii de rasa

public final class RaceModifiers {
    private RaceModifiers() {
    }
    public static final Map<String, Float> FIREBLAST = new HashMap<String, Float>() {{
        final float r = 0.8f;
        final float k = 1.2f;
        final float p = 0.9f;
        final float w = 1.05f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> IGNITE = new HashMap<String, Float>() {{
        final float r = 0.8f;
        final float k = 1.2f;
        final float p = 0.9f;
        final float w = 1.05f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> EXECUTE = new HashMap<String, Float>() {{
        final float r = 1.15f;
        final float k = 1f;
        final float p = 1.1f;
        final float w = 0.8f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> SLAM = new HashMap<String, Float>() {{
        final float r = 0.8f;
        final float k = 1.2f;
        final float p = 0.9f;
        final float w = 1.05f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> DRAIN = new HashMap<String, Float>() {{
        final float r = 0.8f;
        final float k = 1.2f;
        final float p = 0.9f;
        final float w = 1.05f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> DEFLECT = new HashMap<String, Float>() {{
        final float r = 1.2f;
        final float k = 1.4f;
        final float p = 1.3f;
        final float w = 1f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> BACKSTAB = new HashMap<String, Float>() {{
        final float r = 1.2f;
        final float k = 0.9f;
        final float p = 1.25f;
        final float w = 1.25f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};

    public static final Map<String, Float> PARALYSIS = new HashMap<String, Float>() {{
        final float r = 0.9f;
        final float k = 0.8f;
        final float p = 1.2f;
        final float w = 1.25f;
        put("Rogue", r);
        put("Knight", k);
        put("Pyromancer", p);
        put("Wizard", w);
    }};
}



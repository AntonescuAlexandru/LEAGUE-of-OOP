package main;

// clasa care genereaza in functie de strategie (transmisa ca parametru) o celula din harta

public final class CreateCell {
    private CreateCell() {
    }
    public static MapCell createCell(final char landType) {
        switch (landType) {
            case 'V':
                return new MapCell("Volcanic");
            case 'L':
                return new MapCell("Land");
            case 'D':
                return new MapCell("Desert");
            case 'W':
                return new MapCell("Woods");
            default:
                return new MapCell();
        }

    }
}

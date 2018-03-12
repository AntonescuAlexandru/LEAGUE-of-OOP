package main;

// clasa cu ajutorul careia se creeaza harta

public class BattleMap {
    private MapCell[][] map;
    private int lines;
    private int columns;

    //constructor
    public BattleMap(final int lines, final int columns) {
        this.lines = lines;
        this.columns = columns;
        map = new MapCell[lines][columns];
    }

    public final int getLines() {
        return lines;
    }

    public final int getColumns() {
        return columns;
    }

    // insereaza un erou in harta
    public final void insert(final Hero hero) {
        if (hero.alive) {
            if (map[hero.line][hero.column].getHero1() == null) {
                map[hero.line][hero.column].setHero1(hero);
            } else {
                map[hero.line][hero.column].setHero2(hero);
            }
        }
    }

    // sterge toti eroii din harta
    public final void erase() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j].setHero1(null);
                map[i][j].setHero2(null);
            }
        }
    }

    // verifica daca pe coordonatele date ca parametru se afla 2 eroi
    // daca se gasesc 2 eroi inseamna ca o sa aiba loc o lupta
    // si se returneaza celula respectiva
    public final MapCell isBattle(final int line, final int column) {
        if ((map[line][column].getHero1() != null) && (map[line][column].getHero2() != null)) {
            return map[line][column];
        } else {
            return null;
        }
    }
    // se creeaza o celula din harta
    public final void setMapCell(final int i, final int j, final char type) {
        map[i][j] = CreateCell.createCell(type);
    }

}

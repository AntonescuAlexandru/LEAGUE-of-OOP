package main;

// clasa care contine pasii care se urmeaza in timpul unei runde

public class Round {
    private BattleMap map;
    private Hero heroes[];
    private char moves[];

    // constructor
    public Round(final BattleMap map, final Hero[] heroes, final char[] moves) {
        this.map = map;
        this.heroes = heroes;
        this.moves = moves;
    }

    // metoda prin care se executa toti pasii dintr-o runda
    public final void execute() {
        setHeroesPosition();
        map.erase();
        insertHeroesOnMap();
        executeBattles();
    }

    // metoda care seteaza pozitiile eroilor
    private void setHeroesPosition() {
        for (int i = 0; i < heroes.length; i++) {
            if ((!heroes[i].auxiliaryVars.isRooted()) && (heroes[i].alive)) {
                switch (moves[i]) {
                    case 'R':
                        heroes[i].column++;
                        break;
                    case 'L':
                        heroes[i].column--;
                        break;
                    case 'U':
                        heroes[i].line--;
                        break;
                    case 'D':
                        heroes[i].line++;
                        break;
                    default:
                        break;
                }
            }
            if (heroes[i].auxiliaryVars.getRoundsCounter() == 1) {
                heroes[i].auxiliaryVars.setRooted(false);
            }
        }
    }

    // metoda care insereaza eroii in harta
    private void insertHeroesOnMap() {
        for (int i = 0; i < heroes.length; i++) {
            map.insert(heroes[i]);
        }
    }

    // metoda in care se executa bataliile dintr-o runda
    private void executeBattles() {
        for (int i = 0; i < map.getLines(); i++) {
            for (int j = 0; j < map.getColumns(); j++) {
                // verifica daca pe pozitia i, j din harta are loc o batalie
                MapCell cell = map.isBattle(i, j);
                if (cell != null) {
                    // se seteaza oponentul pt fiecare erou1 si pt erou2
                    cell.getHero1().setOpponent(cell.getHero2());
                    cell.getHero2().setOpponent(cell.getHero1());
                    // se seteaza boolean-ul de teren fovorit
                    cell.getHero1().setFavouriteLandBoolean(cell.getType());
                    cell.getHero2().setFavouriteLandBoolean(cell.getType());
                    // se aplica DoT
                    cell.getHero1().applyDamageOverTime();
                    cell.getHero2().applyDamageOverTime();
                    // daca cei doi eroi sunt inca in viata, se executa abilitatile fiecaruia
                    if (cell.getHero1().alive && cell.getHero2().alive) {
                        if (!cell.getHero1().race.equals("Wizard")) {
                            cell.getHero1().ability1();
                            cell.getHero1().ability2();
                            cell.getHero2().ability1();
                            cell.getHero2().ability2();
                        } else {
                            cell.getHero2().ability1();
                            cell.getHero2().ability2();
                            cell.getHero1().ability1();
                            cell.getHero1().ability2();
                        }
                        // se aplica dmg-ul din batalie
                        cell.getHero1().applyCurrentRoundDamage();
                        cell.getHero2().applyCurrentRoundDamage();
                        // se verifica daca exista un castigator
                        verifyWinner(cell);
                    }
                }
            }
        }
    }

    // metoda care verifica daca exista un castigator la finalul unei runde
    private void verifyWinner(final MapCell cell) {
        if (cell.getHero1().alive && !cell.getHero2().alive) {
            cell.getHero1().setXpAndLevel();
        }
        if (!cell.getHero1().alive && cell.getHero2().alive) {
            cell.getHero2().setXpAndLevel();
        }
    }


}

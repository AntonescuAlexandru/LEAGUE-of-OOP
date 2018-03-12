package main;

import fileio.FileSystem;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        try {
            // instantiez un obiect de tip FileSystem pentru citire
            FileSystem fileSystem = new FileSystem(args[0], args[1]);

            // instantiez fiecare celula din harta
            BattleMap map = new BattleMap(fileSystem.nextInt(), fileSystem.nextInt());
            for (int i = 0; i < map.getLines(); i++) {
                char[] line = fileSystem.nextWord().toCharArray();
                for (int j = 0; j < map.getColumns(); j++) {
                    map.setMapCell(i, j, line[j]);
                }
            }

            // instantiez un vector de eroi
            int nrHeroes = fileSystem.nextInt();
            Hero heroes[] = new Hero[nrHeroes];
            for (int i = 0; i < nrHeroes; i++) {
                heroes[i] = CreateHero.createHero(fileSystem.nextWord());
                heroes[i].line = fileSystem.nextInt();
                heroes[i].column = fileSystem.nextInt();
            }

            // citesc miscarile eroilor dintr-o runda si excut bataliile din runda respectiva
            int rounds = fileSystem.nextInt();
            for (int i = 0; i < rounds; i++) {
                char moves[] = fileSystem.nextWord().toCharArray();
                Round round = new Round(map, heroes, moves);
                round.execute();

            }


            // afisare status eroi
            for (int i = 0; i < nrHeroes; i++) {
                if (heroes[i].alive) {
                    fileSystem.writeCharacter(heroes[i].race.charAt(0));
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(heroes[i].level);
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(Math.round(heroes[i].xp));
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(Math.round(heroes[i].hp));
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(heroes[i].line);
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeInt(heroes[i].column);
                } else {
                    fileSystem.writeCharacter(heroes[i].race.charAt(0));
                    fileSystem.writeCharacter(' ');
                    fileSystem.writeWord("dead");
                }
                fileSystem.writeNewLine();
            }
            fileSystem.close();
        } catch (Exception e) {

        }
    }
}

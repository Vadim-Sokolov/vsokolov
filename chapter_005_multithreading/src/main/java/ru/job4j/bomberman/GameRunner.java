package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class GameRunner {

    public static void main(String[] args) {
        Random r = new Random();
        Board board = new Board(r.nextInt(10) + 10);
        Player bomber = board.getPlayer();
        int m = r.nextInt(5) + 1;
        ArrayList<Monster> monsters = new ArrayList();
        for (int i = 0; i < m; i++) {
            monsters.add(new Monster(board.getCell(i + 5, i + 5), board));
        }
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (r.nextInt(100) > 94) {
                    board.getCell(j, i).setEmpty(false);
                }
            }
        }

        bomber.start();
        for (Monster mon : monsters) {
            mon.start();
        }
    }
}

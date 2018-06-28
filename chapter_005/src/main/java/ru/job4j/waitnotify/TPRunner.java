package ru.job4j.waitnotify;

import java.util.Random;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class TPRunner {

    static final String AB = "abcdefghijklmnopqrstuvwxyz";
    static Random rnd = new Random();

    public static String randomString() {
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ThreadPool tp = new ThreadPool();
        for (int i = 0; i < 10; i++) {
            tp.work(new Job(randomString()));
        }
    }
}

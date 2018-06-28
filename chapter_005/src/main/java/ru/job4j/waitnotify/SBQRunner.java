package ru.job4j.waitnotify;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SBQRunner {

    public static void main(String[] args) throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Consumer con = new Consumer(queue);
        Producer prod = new Producer(queue);
        con.start();
        prod.start();
        con.join();
        prod.join();
    }
}

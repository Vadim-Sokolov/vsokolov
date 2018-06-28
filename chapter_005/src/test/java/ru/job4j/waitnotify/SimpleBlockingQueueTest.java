package ru.job4j.waitnotify;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleBlockingQueueTest {

    private SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
    private Consumer con = new Consumer(queue);
    private Producer prod = new Producer(queue);

    @Test
    public void offerTest() throws InterruptedException {
        con.start();
        prod.start();
        con.join();
        prod.join();
    }

    @Test
    public void pollTest() {
    }
}
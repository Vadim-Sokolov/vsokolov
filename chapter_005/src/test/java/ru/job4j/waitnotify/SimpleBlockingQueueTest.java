package ru.job4j.waitnotify;

import org.junit.Test;
import ru.job4j.waitnotify.sbq.Consumer;
import ru.job4j.waitnotify.sbq.Producer;
import ru.job4j.waitnotify.sbq.SimpleBlockingQueue;

import static org.hamcrest.Matchers.is;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */

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
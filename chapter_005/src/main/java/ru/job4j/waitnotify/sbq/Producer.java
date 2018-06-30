package ru.job4j.waitnotify.sbq;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Producer extends Thread implements Runnable {

    private final SimpleBlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(SimpleBlockingQueue<Integer> q) {
        this.queue = q;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.queue.offer(value++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName());
        }
    }
}

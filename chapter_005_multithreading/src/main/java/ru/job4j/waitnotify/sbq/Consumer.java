package ru.job4j.waitnotify.sbq;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Consumer extends Thread implements Runnable {

    private final SimpleBlockingQueue<Integer> queue;

    public Consumer(SimpleBlockingQueue<Integer> q) {
        this.queue = q;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println(this.queue.poll() + " " + getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


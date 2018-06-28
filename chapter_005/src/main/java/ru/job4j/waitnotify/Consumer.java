package ru.job4j.waitnotify;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Consumer extends Thread implements Runnable {

    private SimpleBlockingQueue<Integer> queue;

    public Consumer(SimpleBlockingQueue<Integer> q) {
        this.queue = q;
    }

    public void run() {
        synchronized (this.queue) {
            for (int i = 0; i < 50; i++) {
                if (this.queue.peek() == null) {
                    try {
                        this.queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(this.queue.poll() + " " + getName());
                    this.queue.notify();
                }
            }
        }
    }
}

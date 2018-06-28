package ru.job4j.waitnotify;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Producer extends Thread implements Runnable {

    private SimpleBlockingQueue<Integer> queue;
    int value = 0;

    public Producer(SimpleBlockingQueue<Integer> q) {
        this.queue = q;
    }

    public void run() {
        synchronized (this.queue) {
            for (int i = 0; i < 50; i++) {
                if (this.queue.getQueue().size() > 7) {
                    try {
                        this.queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.queue.offer(value++);
                    System.out.println(getName());
                    this.queue.notify();
                }
            }
        }
    }
}

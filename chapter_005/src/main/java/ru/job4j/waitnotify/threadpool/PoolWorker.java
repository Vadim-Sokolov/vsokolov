package ru.job4j.waitnotify.threadpool;

import ru.job4j.waitnotify.sbq.SimpleBlockingQueue;

import java.util.Queue;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class PoolWorker extends Thread {

    private final SimpleBlockingQueue<Runnable> myJobs;

    public PoolWorker(SimpleBlockingQueue<Runnable> jobs) {
        this.myJobs = jobs;
    }

    public void run() {
        while (true) {
            try {
                this.myJobs.poll().run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName());
        }
    }
}
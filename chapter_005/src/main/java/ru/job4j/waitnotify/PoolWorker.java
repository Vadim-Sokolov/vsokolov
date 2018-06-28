package ru.job4j.waitnotify;

import java.util.Queue;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class PoolWorker extends Thread {

    private final Queue<Runnable> myJobs;

    public PoolWorker(Queue<Runnable> jobs) {
        this.myJobs = jobs;
    }

    public void run() {
        Runnable myJob;
        while (true) {
            synchronized (this.myJobs) {
                while (this.myJobs.isEmpty()) {
                    try {
                        this.myJobs.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                myJob = this.myJobs.poll();
                System.out.println(getName());
                myJob.run();
            }
        }
    }
}

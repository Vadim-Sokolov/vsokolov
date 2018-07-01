package ru.job4j.waitnotify.threadpool;

import ru.job4j.waitnotify.sbq.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class ThreadPool {

    private final List<Thread> threads;
    private final SimpleBlockingQueue<Runnable> tasks;
    int size;

    public ThreadPool() {
        this.size = Runtime.getRuntime().availableProcessors();
        this.tasks = new SimpleBlockingQueue<>();
        this.threads = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            PoolWorker t = new PoolWorker(this.tasks);
            threads.add(t);
            t.start();
        }
    }

    public void work(Runnable job) throws InterruptedException {
        synchronized (this.tasks) {
            this.tasks.offer(job);
            this.tasks.notify();
        }
    }

    public void shutdown() { }
}

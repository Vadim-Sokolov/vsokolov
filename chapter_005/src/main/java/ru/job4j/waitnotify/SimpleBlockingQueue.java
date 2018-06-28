package ru.job4j.waitnotify;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public T peek() {
        synchronized (this) {
            return this.queue.peek();
        }
    }

    public void offer(T value) {
        synchronized (this) {
            this.queue.offer(value);
        }
    }

    public T poll() {
        synchronized (this) {
            return this.queue.poll();
        }
    }

    public Queue<T> getQueue() {
        synchronized (this) {
            return this.queue;
        }
    }
}

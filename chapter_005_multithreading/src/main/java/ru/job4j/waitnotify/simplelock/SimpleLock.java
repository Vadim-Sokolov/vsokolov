package ru.job4j.waitnotify.simplelock;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class SimpleLock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

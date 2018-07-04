package ru.job4j.waitnotify.threadpool;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Job implements Runnable {

    private String name;

    public Job(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }
}

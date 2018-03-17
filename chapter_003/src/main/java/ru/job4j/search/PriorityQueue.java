package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Method uses add(intt index, E value)
     * to insert and element into a correct position,
     * which is evaluated by the priority field.
     * @param task task to add
     */
    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for (Task t : this.tasks) {
                if (task.getPriority() < t.getPriority()) {
                    tasks.add(tasks.indexOf(t), task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

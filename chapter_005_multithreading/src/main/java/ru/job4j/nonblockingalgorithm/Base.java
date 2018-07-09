package ru.job4j.nonblockingalgorithm;
/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class Base {

    private final int id;
    private String name;
    private volatile int version;


    public Base(int id, String name) {
        this.id = id;
        this.name = name;
        this.version = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

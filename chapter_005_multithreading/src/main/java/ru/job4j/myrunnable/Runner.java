package ru.job4j.myrunnable;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        MyRunnable r3 = new MyRunnable();

        r1.start();
        r2.start();
        r3.start();
        System.out.println("Object check: " + MySharedObject.SHAREDINSTANCE.getObject2());
    }
}

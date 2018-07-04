package ru.job4j.myrunnable;

public class MyRunnable extends Thread implements Runnable {

    @Override
    public void run() {
        methodOne();
    }

    public void methodOne() {
        MySharedObject var2 = MySharedObject.SHAREDINSTANCE;
        var2.setObject2((int) (3000 * Math.random()));
        System.out.println(this.getName() + " " + var2.getObject2());
        methodTwo();
    }

    public void methodTwo() {
        MySharedObject var2 = MySharedObject.SHAREDINSTANCE;
        var2.setObject2((int) (3000 * Math.random()));
        System.out.println(this.getName() + " " + var2.getObject2());
    }
}

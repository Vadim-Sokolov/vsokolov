package ru.job4j.myrunnable;

public class MySharedObject {

    public static final MySharedObject SHAREDINSTANCE = new MySharedObject();

    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public Integer getObject2() {
        return object2;
    }

    public void setObject2(Integer object2) {
        this.object2 = object2;
    }

    public Integer getObject4() {
        return object4;
    }

    public void setObject4(Integer object4) {
        this.object4 = object4;
    }
}

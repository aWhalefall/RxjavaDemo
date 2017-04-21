package com.nuoyuan.rxdemo.transportcontrol;

/**
 * Created by weichyang on 2017/4/21.
 */

public class StudentPojo implements Cloneable {

    public String name;
    public String sex;
    public Lesson lesson=new Lesson();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;


    }

    @Override
    protected StudentPojo clone() throws CloneNotSupportedException {

        StudentPojo studentPojo = (StudentPojo) super.clone();
        this.lesson = (Lesson) studentPojo.getLesson().clone();
        return studentPojo;
    }
}

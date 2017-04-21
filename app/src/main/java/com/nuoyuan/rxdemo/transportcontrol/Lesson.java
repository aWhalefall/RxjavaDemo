package com.nuoyuan.rxdemo.transportcontrol;

/**
 * Created by weichyang on 2017/4/21.
 */

public class Lesson  implements Cloneable {
    public String sport; //体育
    public String english;//英语

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    protected Lesson clone() throws CloneNotSupportedException {
        Lesson lesson= (Lesson) super.clone();
        return lesson ;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "sport='" + sport + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
}

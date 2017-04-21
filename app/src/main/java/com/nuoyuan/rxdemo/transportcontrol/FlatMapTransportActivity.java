package com.nuoyuan.rxdemo.transportcontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by weichyang on 2017/4/19.
 * rxjava 变换  FlatMap Api使用
 * 1.变换的优点显现出来了，可以对数据进行多次重复加工
 */


public class FlatMapTransportActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_transport);

        List<StudentPojo> list = initData();

        /**
         * 第一种变换
         */
        flatMapMethod1(list);
        /**
         * 变换组合
         */
        flatMapMethod2(list);


    }


    private void flatMapMethod1(List<StudentPojo> list) {
        Observable.from(list).flatMap(new Func1<StudentPojo, Observable<Lesson>>() {

            @Override
            public Observable<Lesson> call(StudentPojo studentPojo) {
                return Observable.from(new Lesson[]{studentPojo.getLesson()});
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getBufferedDisposableObserver());
    }

    private void flatMapMethod2(List<StudentPojo> list) {
        Observable.from(list).flatMap(new Func1<StudentPojo, Observable<Lesson>>() {

            @Override
            public Observable<Lesson> call(StudentPojo studentPojo) {
                return Observable.from(new Lesson[]{studentPojo.getLesson()});
            }
        }, new Func2<StudentPojo, Lesson, Object>() {
            @Override
            public Object call(StudentPojo studentPojo, Lesson lesson) {
                return lesson;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getBufferedDisposableObserver());
    }

    @Nullable
    private List<StudentPojo> initData() {
        List<StudentPojo> list = null;
        try {
            list = initStudent();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 准备资源
     *
     * @return
     */
    private List<StudentPojo> initStudent() throws CloneNotSupportedException {
        StudentPojo studentPojo = new StudentPojo();
        Lesson lesson = new Lesson();
        List<StudentPojo> pojoList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            StudentPojo studentPojo1 = studentPojo.clone();
            Lesson copyLesson = lesson.clone();
            studentPojo1.setName("张" + i);
            studentPojo1.setSex("nan" + i);
            copyLesson.setEnglish("英语" + i);
            copyLesson.setSport("数学" + i);
            studentPojo1.setLesson(copyLesson);
            pojoList.add(studentPojo1);
        }
        return pojoList;
    }


    /**
     * 获取订阅
     *
     * @return
     */
    public Subscriber getBufferedDisposableObserver() {
        Subscriber subscriber = new Subscriber<Lesson>() {
            @Override
            public void onCompleted() {
                Log.d("completed", "完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("completed", e.toString());
            }

            @Override
            public void onNext(Lesson o) {
                Log.d("onNext", o.toString());
            }
        };
        return subscriber;
    }


}

package com.nuoyuan.rxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by weichyang on 2017/4/19.
 * rxjava 变换   buffre 定时批量发送
 */

/**
 * 普通调用
 * 04-19 10:50:08.139 27325-27325/com.nuoyuan.rxdemo D/onNext: 1
 * 04-19 10:50:08.139 27325-27325/com.nuoyuan.rxdemo D/onNext: 2
 * 04-19 10:50:08.139 27325-27325/com.nuoyuan.rxdemo D/onNext: 3
 * 04-19 10:50:08.139 27325-27325/com.nuoyuan.rxdemo D/onNext: 4
 * 04-19 10:50:08.139 27325-27325/com.nuoyuan.rxdemo D/completed: 完成
 * 添加buffer(3.second)
 * 04-19 10:51:25.884 28774-28774/com.nuoyuan.rxdemo D/onNext: [1, 2, 3, 4]
 * 04-19 10:51:25.884 28774-28774/com.nuoyuan.rxdemo D/completed: 完成
 * buffer( 2)
 * 04-19 10:54:32.284 31977-31977/com.nuoyuan.rxdemo D/onNext: [1, 2]
 * 04-19 10:54:32.284 31977-31977/com.nuoyuan.rxdemo D/onNext: [3, 4]
 * 04-19 10:54:32.284 31977-31977/com.nuoyuan.rxdemo D/completed: 完成
 */


public class RxjavaTransport extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_transport);

//        getObservable().buffer(3)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getBufferedDisposableObserver());

        Observable<Integer> burstyMulticast = getObservable().publish().refCount();
// burstyDebounced will be our buffer closing selector:
        Observable<Integer> burstyDebounced = burstyMulticast.debounce(10, TimeUnit.MILLISECONDS);
// and this, finally, is the Observable of buffers we're interested in:
        Observable<List<Integer>> burstyBuffered = burstyMulticast.buffer(burstyDebounced);

    }

    public Observable<Integer> getObservable() {
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        for (int i = 1; i < 5; i++) {
                            observer.onNext(i);
                        }
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });

        return observable;
    }


    /**
     * 获取订阅
     *
     * @return
     */
    public Subscriber getBufferedDisposableObserver() {
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {
                Log.d("completed", "完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("completed", e.toString());
            }

            @Override
            public void onNext(Object o) {
                Log.d("onNext", o.toString());
            }
        };
        return subscriber;
    }
}

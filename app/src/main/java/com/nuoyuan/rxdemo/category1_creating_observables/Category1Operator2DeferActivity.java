package com.nuoyuan.rxdemo.category1_creating_observables;


import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * 直到订阅才开始初始化Observer ，区别在于 nuber 初始化的区别
 */


public class Category1Operator2DeferActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "defer";
    }

    private int number;

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_2_defer_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a2_defer;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        number = 1;
        Observable justObservable = Observable.just(number);

        number = 2;
        Observable deferObservable = Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(number);  //重新拼装 一个 OBSERVABLE

            }
        });

        number = 3;

        justObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("just result: " + o.toString());
            }
        });

        deferObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("defer1 result: " + o.toString());
            }
        });

        number = 4;

        deferObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("defer2 result: " + o.toString());
            }
        });
    }

    @Override
    protected String getSampleCode() {
        return "    number = 1;\n" +
                "    Observable justObservable = Observable.just(number);\n" +
                "\n" +
                "    number = 2;\n" +
                "    Observable deferObservable = Observable.defer(new Func0<Observable<Integer>>() {\n" +
                "        @Override\n" +
                "        public Observable<Integer> call() {\n" +
                "            return Observable.just(number);\n" +
                "        }\n" +
                "    });\n" +
                "\n" +
                "    number = 3;\n" +
                "\n" +
                "    justObservable.subscribe(new Action1() {\n" +
                "        @Override\n" +
                "        public void call(Object o) {\n" +
                "            System.out.println(\"just result: \" + o.toString());\n" +
                "        }\n" +
                "    });\n" +
                "\n" +
                "    deferObservable.subscribe(new Action1() {\n" +
                "        @Override\n" +
                "        public void call(Object o) {\n" +
                "            System.out.println(\"defer1 result: \" + o.toString());\n" +
                "        }\n" +
                "    });\n" +
                "\n" +
                "    number = 4;\n" +
                "\n" +
                "    deferObservable.subscribe(new Action1() {\n" +
                "        @Override\n" +
                "        public void call(Object o) {\n" +
                "            System.out.println(\"defer2 result: \" + o.toString());\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("just result: 1");
        output.add("\ndefer1 result: 3");
        output.add("\ndefer2 result: 4");

        return output;
    }
}

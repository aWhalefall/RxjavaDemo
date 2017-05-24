package com.nuoyuan.rxdemo.category8_mathematical_and_aggregate_operators;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


public class Category8Operator6CountActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "count";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category8_mathematical_and_aggregate_operators_6_count_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.h6_count;
    }

    @Override
    protected int setImageHeight() {
        return 140;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4)
                .count()
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4)\n" +
                "    .count()\n" +
                "    .subscribe(new Subscriber<Integer>() {\n" +
                "        @Override\n" +
                "        public void onCompleted() {\n" +
                "            System.out.println(\"onCompleted.\");\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onError(Throwable e) {\n" +
                "            System.out.println(\"onError: \" + e.getMessage());\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onNext(Integer integer) {\n" +
                "            System.out.println(\"onNext: \" + integer);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 4");
        output.add("\nonCompleted.");

        return output;
    }
}

package com.nuoyuan.rxdemo.category7_conditional_and_boolean_operators;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


/**
 * Author: weichyang
 * Date:   2017/5/12
 * Description:  原始没有发送任何值， 就发送默认值
 */
public class Category7Operator2DefaultIfEmptyActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "defaultIfEmpty";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_2_default_if_empty_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g2_default_if_empty;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.empty()
                .defaultIfEmpty(1)
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext: " + o);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.empty()\n" +
                "    .defaultIfEmpty(1)\n" +
                "    .subscribe(new Subscriber<Object>() {\n" +
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
                "        public void onNext(Object o) {\n" +
                "            System.out.println(\"onNext: \" + o);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1");
        output.add("\nonCompleted.");

        return output;
    }
}

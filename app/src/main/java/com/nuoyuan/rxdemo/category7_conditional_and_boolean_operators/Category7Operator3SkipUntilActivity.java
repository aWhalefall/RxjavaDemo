package com.nuoyuan.rxdemo.category7_conditional_and_boolean_operators;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;


/**
 * Author: weichyang
 * Date:   2017/5/12
 * Description:  丢弃原始o 直到有一个O 发送了一项数据
 *  注意 observable2 发射的值不参与计算。只作为一个对比
 */
public class Category7Operator3SkipUntilActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "skipUntil";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_3_skip_until_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g3_skip_until;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable observable1 = Observable.interval(1000, TimeUnit.MILLISECONDS).take(5);
        Observable observable2 = Observable.just(1, 2).delay(2500, TimeUnit.MILLISECONDS);

        observable1.skipUntil(observable2)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("onNext: " + aLong);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable observable1 = Observable.interval(1000, TimeUnit.MILLISECONDS).take(5);\n" +
                "Observable observable2 = Observable.just(1, 2).delay(2500, TimeUnit.MILLISECONDS);\n" +
                "\n" +
                "observable1.skipUntil(observable2)\n" +
                "    .subscribe(new Subscriber<Long>() {\n" +
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
                "        public void onNext(Long aLong) {\n" +
                "            System.out.println(\"onNext: \" + aLong);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonNext: 4");
        output.add("\nonCompleted.");

        return output;
    }
}

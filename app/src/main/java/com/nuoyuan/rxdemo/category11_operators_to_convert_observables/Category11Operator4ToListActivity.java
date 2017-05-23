package com.nuoyuan.rxdemo.category11_operators_to_convert_observables;

import com.nuoyuan.rxdemo.R;
import com.nuoyuan.rxdemo.base.SampleTempActivity;


import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;


public class Category11Operator4ToListActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "toList";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_4_to_list_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k4_to_list;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4).toList()
                .subscribe(new Subscriber<List<Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        System.out.println("onNext: " + integers);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4).toList()\n" +
                "    .subscribe(new Subscriber<List<Integer>>() {\n" +
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
                "        public void onNext(List<Integer> integers) {\n" +
                "            System.out.println(\"onNext: \" + integers);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: [1, 2, 3, 4]");
        output.add("\nonCompleted.");

        return output;
    }
}

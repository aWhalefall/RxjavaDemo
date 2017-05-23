package com.nuoyuan.rxdemo.category11_operators_to_convert_observables;

import com.nuoyuan.rxdemo.base.SampleTempActivity;
import com.nuoyuan.rxdemo.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rx.Observable;


public class Category11Operator1GetIteratorActivity extends SampleTempActivity {

    @Override
    protected String getOperatorName() {
        return "getIterator";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_1_get_iterator_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k1_get_iterator;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Iterator<Integer> iterator = Observable.just(1, 2, 3, 4, 5).toBlocking().getIterator();
        while (iterator.hasNext()) {
            System.out.println("Data: " + iterator.next());
        }
    }

    @Override
    protected String getSampleCode() {
        return "Iterator<Integer> iterator = Observable.just(1, 2, 3, 4, 5).toBlocking().getIterator();\n" +
                "while (iterator.hasNext()) {\n" +
                "    System.out.println(\"Data: \" + iterator.next());\n" +
                "}";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("Data: 1");
        output.add("\nData: 2");
        output.add("\nData: 3");
        output.add("\nData: 4");
        output.add("\nData: 5");

        return output;
    }
}

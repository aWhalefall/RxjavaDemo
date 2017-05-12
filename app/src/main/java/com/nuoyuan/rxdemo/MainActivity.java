package com.nuoyuan.rxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nuoyuan.rxdemo.category5_error_handling_operators.Category5_ErrorHandlingOperatorsActivity;
import com.nuoyuan.rxdemo.category7_conditional_and_boolean_operators.Category7_ConditionalAndBooleanOperatorsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 1. 创建操作(Creating Observables)
     *
     * @param view
     */
    public void jumpToCreatingObservablesActivity(View view) {
//        startActivity(new Intent(MainActivity.this, .class));
    }

    /**
     * 2. 变换操作(Transforming Observables)
     *
     * @param view
     */
    public void jumpToTransformingObservablesActivity(View view) {
        //   startActivity(new Intent(MainActivity.this, Category2_TransformingObservablesActivity.class));
    }

    /**
     * 3. 过滤操作(Filtering Observables)
     *
     * @param view
     */
    public void jumpToFilteringObservablesActivity(View view) {
        //  startActivity(new Intent(MainActivity.this, Category3_FilteringObservablesActivity.class));
    }

    /**
     * 4. 组合操作(Combining Observables)
     *
     * @param view
     */
    public void jumpToCombiningObservablesActivity(View view) {
        //   startActivity(new Intent(MainActivity.this, Category4_CombiningObservablesActivity.class));
    }

    /**
     * 5. 错误处理(Error Handling Operators)
     *
     * @param view
     */
    public void jumpToErrorHandlingOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category5_ErrorHandlingOperatorsActivity.class));
    }

    /**
     * 6. 辅助操作(Observable Utility Operators)
     *
     * @param view
     */
    public void jumpToObservableUtilityOperatorsActivity(View view) {
        //   startActivity(new Intent(MainActivity.this, Category6_ObservableUtilityOperatorsActivity.class));
    }

    /**
     * 7. 条件和布尔操作\n(Conditional and Boolean Operators)
     *
     * @param view
     */
    public void jumpToConditionalAndBooleanOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category7_ConditionalAndBooleanOperatorsActivity.class));
    }

    /**
     * 8. 算术和聚合操作(Mathematical and Aggregate Operators)
     *
     * @param view
     */
    public void jumpToMathematicalAndAggregateOperatorsActivity(View view) {
        //   startActivity(new Intent(MainActivity.this, Category8_MathematicalAndAggregateOperatorsActivity.class));
    }

    /**
     * 9. (Backpressure Operators)
     *
     * @param view
     */
    public void jumpToBackpressureOperatorsActivity(View view) {
        //   startActivity(new Intent(MainActivity.this, Category9_BackpressureOperatorsActivity.class));
    }

    /**
     * 10. 连接操作(Connectable Observable Operators)
     *
     * @param view
     */
    public void jumpToConnectableObservableOperatorsActivity(View view) {
        //    startActivity(new Intent(MainActivity.this, Category10_ConnectableObservableOperatorsActivity.class));
    }

    /**
     * 11. 转换操作(Operators to Convert Observables)
     *
     * @param view
     */
    public void jumpToOperatorsToConvertObservablesActivity(View view) {
        //   startActivity(new Intent(MainActivity.this, Category11_OperatorsToConvertObservablesActivity.class));
    }

}

package com.koreait.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String operator = "";

    private TextView tv;
    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvDisplay);
        et1 = findViewById(R.id.etText1);
        et2 = findViewById(R.id.etText2);
        et3 = findViewById(R.id.etText3);
    }
    // Clear 버튼 이벤트
    public void clkClear(View v) {
        tv.setText("");
        et1.getText().clear();
        et2.setText("");
        et3.setText("");
    }

    // 숫자 버튼 이벤트
    public void clkNumber(View v) {
        TextView tv1 = (TextView) v;
        String s = tv1.getText().toString();
        if("".equals(operator)){
            String oldVal = et1.getText().toString();
            et1.setText(oldVal + s);
//            et1.append(s);
        } else {
            String oldVal = et2.getText().toString();
            et2.setText(oldVal + s);
//            et2.append(s);
        }
        tv.append(s);
    }
    //사칙연산 버튼 이벤트
    public void clkOperator(View v){
        TextView tv1 = (TextView) v;
        String oper = tv1.getText().toString();
        operator = oper;
        tv.append(oper);
    }

    // equal 버튼 이벤트
    public void clkEqual(View v){
//        addTvDisplay("=");
        TextView tv1 = (TextView) v;
        String s = tv1.getText().toString();
        tv.append(s);

        String strVal1 = et1.getText().toString();
        String strVal2 = et2.getText().toString();
        String strVal3 = "";

        int intVal1 = Integer.parseInt(strVal1);
        int intVal2 = Integer.parseInt(strVal2);

        switch (operator){
            case "/":
                strVal3 = String.valueOf((double) intVal1/intVal2);
                break;
            case "*":
                strVal3 = String.valueOf(intVal1 * intVal2);
                break;
            case "+":
                strVal3 = String.valueOf(intVal1 + intVal2);
                break;
            case "-":
                strVal3 = String.valueOf(intVal1 - intVal2);
                break;
        }
        operator = "";
        et3.append(strVal3);
        tv.append(strVal3);

    }
    private void addTvDisplay(String val){
        String oldval = tv.getText().toString();
        tv.setText((oldval + val));

        tv.append(val);
    }
}
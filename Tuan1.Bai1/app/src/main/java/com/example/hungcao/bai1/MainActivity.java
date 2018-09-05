package com.example.hungcao.bai1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {
    int a, b;

    public int getIntValue(int id) {
        EditText input = findViewById(id);
        return Integer.parseInt(input.getText().toString());
    }

    public double getDoubleValue(int id) {
        EditText input = findViewById(id);
        return Double.parseDouble(input.getText().toString());
    }

    public void setValue(int id, String mess) {
        TextView result = findViewById(id);
        result.setText(mess);
    }

    public boolean checkEmpty(int id) {
        EditText input = findViewById(id);
        String inputString = input.getText().toString();
        return !inputString.matches("");
    }

    public int gcd(int a, int b) {
        return a == 0 ? b: gcd(b%a, a);
    }

    public String getTextValue(int id) {
        EditText input = findViewById(id);
        return input.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnTong2So(View v) {
        if(checkEmpty(R.id.inputA) && checkEmpty(R.id.inputB)) {
            a = getIntValue(R.id.inputA);
            b = getIntValue(R.id.inputB);
            setValue(R.id.result, Integer.toString(a + b));
        }
    }

    public void btnHieu2So(View v) {
        if(checkEmpty(R.id.inputA) && checkEmpty(R.id.inputB)) {
            a = getIntValue(R.id.inputA);
            b = getIntValue(R.id.inputB);
            setValue(R.id.result, Integer.toString(a - b));
        }
    }

    public void btnTich2So(View v) {
        if(checkEmpty(R.id.inputA) && checkEmpty(R.id.inputB)) {
            a = getIntValue(R.id.inputA);
            b = getIntValue(R.id.inputB);
            setValue(R.id.result, Integer.toString(a * b));
        }
    }

    public void btnThuong2So(View v) {
        if(checkEmpty(R.id.inputA) && checkEmpty(R.id.inputB)) {
            Double _a = getDoubleValue(R.id.inputA);
            Double _b = getDoubleValue(R.id.inputB);
            Double rs = _a/_b;
            setValue(R.id.result, Double.toString(rs));
        }
    }

    public void btnGCD(View v) {
        if(checkEmpty(R.id.inputA) && checkEmpty(R.id.inputB)) {
            a = getIntValue(R.id.inputA);
            b = getIntValue(R.id.inputB);
            setValue(R.id.result, Integer.toString(gcd(a, b)));
        }
    }



}

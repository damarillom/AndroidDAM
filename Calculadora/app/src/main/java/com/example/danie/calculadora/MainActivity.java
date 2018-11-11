package com.example.danie.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static int num1 = 0;
    static int num2 = 0;
    static int result = 0;
    static char expression = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setFocusable(false);
    }

    public void add1(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 1;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add2(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 2;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add3(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 3;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add4(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 4;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add5(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 5;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add6(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 6;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add7(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 7;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add8(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 8;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add9(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 9;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add0(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String number = "";
        int num = 0;

        number = editText.getText().toString() + num;
        editText.setText(number);
    }
    public void add(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        try {
            num1 = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        expression = '+';
        editText.setText("");
    }
    public void subtract(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        try {
            num1 = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        expression = '-';
        editText.setText("");
    }
    public void multiply(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        try {
            num1 = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        expression = '*';
        editText.setText("");
    }
    public void divide(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        try {
            num1 = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        expression = '/';
        editText.setText("");
    }


    public void equals(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        try {
            num2 = Integer.parseInt(editText.getText().toString());
        } catch (Exception e) {

        }
        if (expression == '+') {
            result = num1 + num2;
        } else if (expression == '-') {
            result = num1 - num2;
        } else if (expression == '*') {
            result = num1 * num2;
        } else {
            result = num1 / num2;
        }
        editText.setText(""+result);
    }

    public void ac(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
        num1 = 0;
        num2 = 0;
    }
}

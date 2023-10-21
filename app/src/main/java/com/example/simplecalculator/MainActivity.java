package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultScreen;
    MaterialButton btnC, btnEqual, btnDiv, btnTimes, btnMinus, btnSum;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    double value1, value2;
    String operation, aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultScreen = findViewById(R.id.result_screen);

        assignId(btnC, R.id.button_C);
        assignId(btnEqual, R.id.button_equal);
        assignId(btnDiv, R.id.button_div);
        assignId(btnTimes, R.id.button_times);
        assignId(btnMinus, R.id.button_minus);
        assignId(btnSum, R.id.button_sum);
        assignId(btn0, R.id.button_0);
        assignId(btn1, R.id.button_1);
        assignId(btn2, R.id.button_2);
        assignId(btn3, R.id.button_3);
        assignId(btn4, R.id.button_4);
        assignId(btn5, R.id.button_5);
        assignId(btn6, R.id.button_6);
        assignId(btn7, R.id.button_7);
        assignId(btn8, R.id.button_8);
        assignId(btn9, R.id.button_9);
    }

    public void assignId(MaterialButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        MaterialButton btn = (MaterialButton) view;

        if (!btn.getText().toString().equals("+") && !btn.getText().toString().equals("-") && !btn.getText().toString().equals("*") && !btn.getText().toString().equals("/") && !btn.getText().toString().equals("AC") && !btn.getText().toString().equals("="))
        {
            if (!resultScreen.getText().toString().equals("0"))
            {
                resultScreen.setText(resultScreen.getText().toString() + btn.getText().toString());
            }
            else
            {
                resultScreen.setText(btn.getText().toString());
            }
            aux = resultScreen.getText().toString();
        }

        if (btn.getText().toString().equals("+") || btn.getText().toString().equals("-") || btn.getText().toString().equals("*") || btn.getText().toString().equals("/"))
        {
            value1 = Double.parseDouble(resultScreen.getText().toString());
            operation = btn.getText().toString();
            resultScreen.setText("0");
        }

        if (btn.getText().toString().equals("AC"))
        {
            value1 = 0;
            value2 = 0;
            resultScreen.setText("0");
        }

        if (btn.getText().toString().equals("="))
        {
            value2 = Double.parseDouble(aux);
            double result;

            switch (operation)
            {
                case "+":
                    result = value1 + value2;
                    break;
                case  "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case  "/":
                    result = value1 / value2;
                    break;
                default:
                    result = value1 + Double.parseDouble(aux);
            }

            resultScreen.setText(String.valueOf(result));
            value1 = result;

        }
    }
}
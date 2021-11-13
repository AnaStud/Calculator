package ru.anasoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    Action myCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
        initButtons();

        myCalculator = new Action();
    }

    protected void initButtons() {

        Button buttonClear = findViewById(R.id.buttonClear);
        initButtonClear(buttonClear);

        Button button1 = findViewById(R.id.button1);
        initButton(button1, 1);

        Button button2 = findViewById(R.id.button2);
        initButton(button2, 2);

        Button button3 = findViewById(R.id.button3);
        initButton(button3, 3);

        Button button4 = findViewById(R.id.button4);
        initButton(button4, 4);

        Button button5 = findViewById(R.id.button5);
        initButton(button5, 5);

        Button button6 = findViewById(R.id.button6);
        initButton(button6, 6);

        Button button7 = findViewById(R.id.button7);
        initButton(button7, 7);

        Button button8 = findViewById(R.id.button8);
        initButton(button8, 8);

        Button button9 = findViewById(R.id.button9);
        initButton(button9, 9);

        Button button0 = findViewById(R.id.button0);
        initButton(button0, 0);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        initButtonOperation(buttonPlus);

        Button buttonMinus = findViewById(R.id.buttonMinus);
        initButtonOperation(buttonMinus);

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        initButtonOperation(buttonMultiply);

        Button buttonShare = findViewById(R.id.buttonShare);
        initButtonOperation(buttonShare);

        Button buttonEqually = findViewById(R.id.buttonEqually);
        initButtonOperation(buttonEqually);

    }

    protected void initButtonClear(Button buttonClear) {
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCalculator.clearAll();
                setTextResult("0.0");
            }
        });
    }

    protected void initButton(Button button, int num) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCalculator.setParam(num);
                setTextResult(String.valueOf(myCalculator.getParam()));
            }
        });
    }

    private void initButtonOperation(Button buttonOperation) {
        buttonOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCalculator.doOperation(buttonOperation.getText().toString());
                setTextResult(String.valueOf(myCalculator.getResult()));
            }
        });
    }

    protected void setTextResult(String result) {
        textResult.setText(result);
    }

}
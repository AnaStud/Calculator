package ru.anasoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        myCalculator = new Action();

        initButtons();

    }

    protected void initButtons() {

        initButtonClear(R.id.buttonClear);

        initButton(R.id.button1, getString(R.string._1));
        initButton(R.id.button2, getString(R.string._2));
        initButton(R.id.button3, getString(R.string._3));
        initButton(R.id.button4, getString(R.string._4));
        initButton(R.id.button5, getString(R.string._5));
        initButton(R.id.button6, getString(R.string._6));
        initButton(R.id.button7, getString(R.string._7));
        initButton(R.id.button8, getString(R.string._8));
        initButton(R.id.button9, getString(R.string._9));
        initButton(R.id.button0, getString(R.string._0));

        initButtonOperation(R.id.buttonPlus);
        initButtonOperation(R.id.buttonMinus);
        initButtonOperation(R.id.buttonMultiply);
        initButtonOperation(R.id.buttonShare);
        initButtonOperation(R.id.buttonEqually);

        initButtonPoint(R.id.buttonPoint);

    }

    protected void initButtonClear(int buttonID) {
        Button buttonClear = findViewById(buttonID);
        buttonClear.setOnClickListener(v -> {
            myCalculator.clearParam();
            myCalculator.clearResult();
            setTextResult(myCalculator.getParam());
        });
    }

    protected void initButton(int buttonID, String num) {
        Button button = findViewById(buttonID);
        button.setOnClickListener(v -> {
            myCalculator.addNumToParam(num);
            setTextResult(myCalculator.getParam());
        });
    }

    private void initButtonOperation(int buttonID) {
        Button buttonOperation = findViewById(buttonID);
        buttonOperation.setOnClickListener(v -> {
            myCalculator.doOperation(buttonOperation.getText().toString());
            setTextResult(myCalculator.getResult());
        });
    }

    private void initButtonPoint(int buttonID) {
        Button buttonPoint = findViewById(buttonID);
        buttonPoint.setOnClickListener(v -> {
            myCalculator.addPoint();
            setTextResult(myCalculator.getParam());
        });
    }

    protected void setTextResult(String result) {
        textResult.setText(result);
    }

}
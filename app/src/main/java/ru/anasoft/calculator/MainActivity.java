package ru.anasoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textResult);
        initButtons();
    }

    protected void initButtons() {

        Button button1 = findViewById(R.id.button1);
        initButton(button1, "1");

        Button button2 = findViewById(R.id.button2);
        initButton(button2, "2");

        Button button3 = findViewById(R.id.button3);
        initButton(button3, "3");

        Button button4 = findViewById(R.id.button4);
        initButton(button4, "4");

        Button button5 = findViewById(R.id.button5);
        initButton(button5, "5");

        Button button6 = findViewById(R.id.button6);
        initButton(button6, "6");

        Button button7 = findViewById(R.id.button7);
        initButton(button7, "7");

        Button button8 = findViewById(R.id.button8);
        initButton(button8, "8");

        Button button9 = findViewById(R.id.button9);
        initButton(button9, "9");

        Button button0 = findViewById(R.id.button0);
        initButton(button0, "0");

    }

    protected void initButton(Button button, String str) {
        button.setOnClickListener(v -> setTextResult(str));
    }

    protected void setTextResult(String result) {
        textResult.setText(result);
    }

}
package ru.anasoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    int numberTheme;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        numberTheme = getIntent().getExtras().getInt(Constants.MY_THEME);
        radioGroup = findViewById(R.id.radioGroupTheme);

        initRadioGroup();
        initButtonOK();
    }

    private void initRadioGroup() {
        switch (numberTheme) {
            case 1:
                radioGroup.check(R.id.radioButtonTheme1);
                break;
            case 2:
                radioGroup.check(R.id.radioButtonTheme2);
                break;
            case 3:
                radioGroup.check(R.id.radioButtonTheme3);
                break;
        }

    }

    private void initButtonOK() {
        Button buttonOK = findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(v -> {
            Intent intentResult = new Intent();
            intentResult.putExtra(Constants.MY_THEME, getMyChoice());
            setResult(RESULT_OK, intentResult);
            finish();
        });
    }

    private int getMyChoice() {
         switch (radioGroup.getCheckedRadioButtonId()) {
            case (R.id.radioButtonTheme1):
                return 1;
            case (R.id.radioButtonTheme2):
                return 2;
            case (R.id.radioButtonTheme3):
                return 3;
        }
        return 1;
    }

}
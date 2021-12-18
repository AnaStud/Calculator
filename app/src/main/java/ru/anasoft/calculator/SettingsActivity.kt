package ru.anasoft.calculator

import androidx.appcompat.app.AppCompatActivity
import android.widget.RadioGroup
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class SettingsActivity : AppCompatActivity() {
    private var numberTheme = 0
    private var radioGroup: RadioGroup? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        numberTheme = intent.extras!!.getInt(Constants.MY_THEME)
        radioGroup = findViewById(R.id.radioGroupTheme)
        initRadioGroup()
        initButtonOK()
    }

    private fun initRadioGroup() {
        when (numberTheme) {
            1 -> radioGroup!!.check(R.id.radioButtonTheme1)
            2 -> radioGroup!!.check(R.id.radioButtonTheme2)
            3 -> radioGroup!!.check(R.id.radioButtonTheme3)
        }
    }

    private fun initButtonOK() {
        val buttonOK = findViewById<Button>(R.id.buttonOK)
        buttonOK.setOnClickListener {
            val intentResult = Intent()
            intentResult.putExtra(Constants.MY_THEME, myChoice)
            setResult(RESULT_OK, intentResult)
            finish()
        }
    }

    private val myChoice: Int
        get() {
            when (radioGroup!!.checkedRadioButtonId) {
                R.id.radioButtonTheme1 -> return 1
                R.id.radioButtonTheme2 -> return 2
                R.id.radioButtonTheme3 -> return 3
            }
            return 1
        }
}
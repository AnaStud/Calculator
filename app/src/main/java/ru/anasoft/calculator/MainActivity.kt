package ru.anasoft.calculator

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult

open class MainActivity : AppCompatActivity() {
    private var textResult: TextView? = null
    private var myCalculator = Action()
    private var linearLayout: LinearLayout? = null
    private var someActivityResultLauncher = registerForActivityResult(
        StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            Constants.themeActivityMain = data!!.getIntExtra(Constants.MY_THEME, 1)
            recreate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        when (Constants.themeActivityMain) {
            1 -> {
                setTheme(R.style.MyStyle1)
            }
            2 -> {
                setTheme(R.style.MyStyle2)
            }
            3 -> {
                setTheme(R.style.MyStyle3)
            }
            else -> {
                Constants.themeActivityMain = 1
                setTheme(R.style.MyStyle1)
            }
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFon()
        textResult = findViewById(R.id.textResult)
        initButtons()
    }

    private fun setFon() {
        linearLayout = findViewById(R.id.mainLayout)
        var fon = R.drawable.fon1
        with(linearLayout) {
            when (Constants.themeActivityMain) {
                1 -> fon = R.drawable.fon1
                2 -> fon = R.drawable.fon2
                3 -> fon = R.drawable.fon3
            }
            this?.setBackgroundResource(fon)
        }
    }

    private fun initButtons() {
        initButtonSettings(R.id.buttonSettings)
        initButtonClear(R.id.buttonClear)
        initButton(R.id.button1, getString(R.string._1))
        initButton(R.id.button2, getString(R.string._2))
        initButton(R.id.button3, getString(R.string._3))
        initButton(R.id.button4, getString(R.string._4))
        initButton(R.id.button5, getString(R.string._5))
        initButton(R.id.button6, getString(R.string._6))
        initButton(R.id.button7, getString(R.string._7))
        initButton(R.id.button8, getString(R.string._8))
        initButton(R.id.button9, getString(R.string._9))
        initButton(R.id.button0, getString(R.string._0))
        initButtonOperation(R.id.buttonPlus)
        initButtonOperation(R.id.buttonMinus)
        initButtonOperation(R.id.buttonMultiply)
        initButtonOperation(R.id.buttonShare)
        initButtonOperation(R.id.buttonEqually)
        initButtonPoint(R.id.buttonPoint)
    }

    private fun initButtonSettings(buttonID: Int) {
        val buttonSettings = findViewById<Button>(buttonID)
        buttonSettings.setOnClickListener {
            val runSettings = Intent(this@MainActivity, SettingsActivity::class.java)
            runSettings.putExtra(Constants.MY_THEME, Constants.themeActivityMain)
            someActivityResultLauncher.launch(runSettings)
        }
    }

    private fun initButtonClear(buttonID: Int) {
        val buttonClear = findViewById<Button>(buttonID)
        buttonClear.setOnClickListener {
            myCalculator.clearParam()
            myCalculator.clearResult()
            setTextResult(myCalculator.getParam())
        }
    }

    private fun initButton(buttonID: Int, num: String?) {
        val button = findViewById<Button>(buttonID)
        button.setOnClickListener {
            myCalculator.addNumToParam(num)
            setTextResult(myCalculator.getParam())
        }
    }

    private fun initButtonOperation(buttonID: Int) {
        val buttonOperation = findViewById<Button>(buttonID)
        buttonOperation.setOnClickListener {
            myCalculator.doOperation(buttonOperation.text.toString())
            setTextResult(myCalculator.getResult())
        }
    }

    private fun initButtonPoint(buttonID: Int) {
        val buttonPoint = findViewById<Button>(buttonID)
        buttonPoint.setOnClickListener {
            myCalculator.addPoint()
            setTextResult(myCalculator.getParam())
        }
    }

    private fun setTextResult(result: String?) {
        textResult!!.text = result
    }
}
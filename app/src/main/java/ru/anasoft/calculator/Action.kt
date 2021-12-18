package ru.anasoft.calculator

import java.lang.StringBuilder

class Action {
    private val inputParam: StringBuilder = StringBuilder("0")
    private var param = 0.0
    private var lastOperation: String? = null
    private var result = 0.0
    private var usePoint = false
    fun clearParam() {
        param = 0.0
        inputParam.replace(0, inputParam.length, "0")
        usePoint = false
    }

    fun clearResult() {
        lastOperation = "="
        result = 0.0
    }

    fun addNumToParam(num: String?) {
        if (inputParam.toString() == "0") {
            inputParam.delete(0, 1)
        }
        inputParam.append(num)
        param = inputParam.toString().toDouble()
    }

    fun getParam(): String {
        return inputParam.toString()
    }

    fun getResult(): String {
        return result.toString()
    }

    fun doOperation(operation: String?) {
        when (lastOperation) {
            "+" -> result += param
            "-" -> result -= param
            "*" -> result *= param
            "/" -> result /= param
            "=" -> if (param != 0.0) {
                result = param
            }
        }
        lastOperation = operation
        clearParam()
    }

    fun addPoint() {
        if (!usePoint) {
            usePoint = true
            inputParam.append(".")
        }
    }

    init {
        clearParam()
        clearResult()
    }
}
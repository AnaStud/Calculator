package ru.anasoft.calculator;

public class Action {

    private double param;
    private String lastOperation;
    private double result;

    public Action() {
        clearAll();
    }

    public void clearAll() {
        this.param = 0;
        this.lastOperation = "=";
        this.result = 0;
    }

    public void setParam(int num) {
        this.param = this.param * 10 + num;
    }

    public double getParam() {
        return param;
    }

    public double getResult() {
        return result;
    }

    public void doOperation(String operation) {

        switch (this.lastOperation){
            case ("+"):
                this.result = this.result + this.param;
                break;
            case ("-"):
                this.result = this.result - this.param;
                break;
            case ("*"):
                this.result = this.result * this.param;
                break;
            case ("/"):
                this.result = this.result / this.param;
                break;
            case ("="):
                if (this.param != 0) {
                    this.result = this.param;
                }
                break;
        }

        this.lastOperation = operation;
        this.param = 0;

    }

 }

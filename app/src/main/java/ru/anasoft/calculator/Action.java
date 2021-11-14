package ru.anasoft.calculator;

public class Action {

    private StringBuilder inputParam;
    private double param;
    private String lastOperation;
    private double result;
    private boolean usePoint;

    public Action() {
        this.inputParam = new StringBuilder("0");
        clearParam();
        clearResult();
    }

    public void clearParam() {
        this.param = 0;
        this.inputParam.replace(0, this.inputParam.length(), "0");
        this.usePoint = false;
    }

    public void clearResult() {
        this.lastOperation = "=";
        this.result = 0;
    }

    public void addNumToParam(String num) {
        if (this.inputParam.toString().equals("0")) {
            this.inputParam.delete(0, 1);
        }
        this.inputParam.append(num);
        this.param = Double.parseDouble(this.inputParam.toString());
    }

    public String getParam() {
        return this.inputParam.toString();
    }

    public String getResult() {
        return String.valueOf(this.result);
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
        clearParam();

    }

    public void addPoint() {
        if (!this.usePoint) {
            this.usePoint = true;

            if (this.inputParam.length() == 0) {
                this.inputParam.append("0");
            }
            this.inputParam.append(".");
        }
    }
}

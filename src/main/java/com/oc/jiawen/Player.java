package com.oc.jiawen;

public abstract class Player {
    public InputChecker getInputChecker() {
        return inputChecker;
    }

    public void setInputChecker(InputChecker inputChecker) {
        this.inputChecker = inputChecker;
    }

    private InputChecker inputChecker;

}

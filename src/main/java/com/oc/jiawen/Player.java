package com.oc.jiawen;

public abstract class Player {

    private InputChecker inputChecker = new InputChecker();

    /**
     * getInputChecker() est un Getter permettant de récupérer InputChecker
     * @return un objet InputChecker
     */
    public InputChecker getInputChecker() {
        return inputChecker;
    }

}

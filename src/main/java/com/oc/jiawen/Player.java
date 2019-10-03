package com.oc.jiawen;

public abstract class Player {

    /**
     * l'utilisatation des objets de type InputChecker est encapsulée dans la classe Player.
     */
    private InputChecker inputChecker = new InputChecker();

    /**
     * getInputChecker() est un Getter permettant de récupérer InputChecker
     * @return un objet InputChecker
     */
    public InputChecker getInputChecker() {
        return inputChecker;
    }

}

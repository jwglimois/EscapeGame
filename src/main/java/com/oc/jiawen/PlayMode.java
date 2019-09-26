package com.oc.jiawen;

import java.util.List;

public abstract class PlayMode {
    private String role;
    private boolean devMode;

    private InputChecker inputChecker;
    public InputChecker getInputChecker() {
        return inputChecker;
    }


    private static final List<String> STRINGS = List.of("Quitter", "Mode Challenger", "Mode Defenseur", "Mode duel");

    public void runGame(){
        displayGameRules();
        askSecretNb();
    }
    public void displayGameRules(){
        System.out.println("Devinez la combinaison secréte en 4 chiffres. 10 fois d'essai possible.");
    }
    public abstract void askSecretNb();
}

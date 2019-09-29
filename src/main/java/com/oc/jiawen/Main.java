package com.oc.jiawen;

public class Main {

    public static void main(String[] args) {
        int newPlayMode = askNewPlayMode();
        boolean playOrNot;
        do {
            if (newPlayMode == 1) {
                ModeChallenger mChallenger = new ModeChallenger();
                playOrNot = mChallenger.runGame();
            } else if (newPlayMode == 2) {
                ModeDefender mDefender = new ModeDefender();
                playOrNot = mDefender.runGame();
            } else {
                ModeDuel mDuel = new ModeDuel();
                playOrNot = mDuel.runGame();
            }

        } while (!playOrNot);


    }

    public static int askNewPlayMode(){
        Human utilisateur = new Human();
        System.out.println("Choisissez votre mode de jeu.");
        System.out.println("1 pour Mode Challenger. C'est-à-dire que l'utilisateur est l'attaquant, et la machine est le défenseur.");
        System.out.println("2 pour Mode Défenseur. C'est-à-dire que l'utilisateur est le défenseur, et la machine est l'attaquant'.");
        System.out.println("3 pour Mode Duel. C'est-à-dire que l'utilisateur et la machine jouent tour à tour'.");

        InputChecker myInputChecker = utilisateur.getInputChecker();
        int newPlayMode = myInputChecker.checkInputNextPlayMode();
        return newPlayMode;

    }
}

package com.oc.jiawen;

public class Main {

    public static void main(String[] args) {

        int newPlayMode;
        boolean playOrNot=true;
        ModeChallenger mChallenger = new ModeChallenger();
        ModeDefender mDefender = new ModeDefender();
        ModeDuel mDuel = new ModeDuel();
        do {
            newPlayMode = askNewPlayMode();
            if (newPlayMode == 1) {
                playOrNot = mChallenger.runGame();
            } else if (newPlayMode == 2) {
                playOrNot = mDefender.runGame();
            } else {
                playOrNot = mDuel.runGame();
            }
        } while (playOrNot);


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

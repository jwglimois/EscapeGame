package com.oc.jiawen;

public class Main {

    public static void main(String[] args) {
        startGame();
    }

    /**
     * startGame() permet à l'utilisateur de démarrer le jeu.
     */
    public static void startGame(){
        Human human = new Human();
        int newPlayMode;
        boolean playAgain;
        ModeChallenger mChallenger = new ModeChallenger();
        ModeDefender mDefender = new ModeDefender();
        ModeDuel mDuel = new ModeDuel();
        do {
            mChallenger.display3PlayModes();
            newPlayMode = human.replyNewPlayMode();

            if (newPlayMode == 1) {
                playAgain = mChallenger.runGame();
            } else if (newPlayMode == 2) {
                playAgain = mDefender.runGame();
            } else {
                playAgain = mDuel.runGame();
            }
        } while(playAgain);

    }

}

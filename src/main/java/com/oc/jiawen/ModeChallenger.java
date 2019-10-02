package com.oc.jiawen;

import java.util.Arrays;

public class ModeChallenger extends PlayMode {
    public static void main(String[] args) {

        ModeChallenger mChallenger = new ModeChallenger();
        mChallenger.askSecretNb();



    }


    @Override
    public void askSecretNb() {
        Human attackerHuman = new Human();
        Computer defenderComputer = new Computer();
        InputChecker inputChecker = attackerHuman.getInputChecker();

        String hint="";
        int nbRound=0;
        int[] tabRandom = defenderComputer.giveRandomNb();

        guessInLoop(attackerHuman, inputChecker, hint, nbRound, tabRandom);

    }


    public void guessInLoop(Human attackerHuman, InputChecker inputChecker,  String hint, int nbRound,int[] tabRandom){
        do {
            //Vérifier si la taille de saisie est bien 4
            String inputStr = inputChecker.askInput4Digit();

            int[] tabInt = attackerHuman.replyFourDigit(inputStr);
            String[] tabHint = new String[4];
            for (int i = 0; i < 4; i++) {
                tabHint[i] = inputChecker.compareInputInt(tabInt[i], tabRandom[i]);
                if (tabHint[i].equals("=")) {
                    hint += "=";
                }
            }
            if(hint.length()!=4){
                hint="";
            }

            System.out.println("[Arbitre] : Votre proposition : " + inputStr + " -> C'est faux! Voici l'indice: " + Arrays.toString(tabHint));
            nbRound++;
        }while(!hint.contains("====") && nbRound<10);

        if(hint.equals("====")){
            System.out.println("[Arbitre] : Bravo! Vous avez gagné en "+ nbRound + " tour(s)." );
        }else{
            if(nbRound==10){
                System.out.println("[Arbitre] : Dommage!! Vous avez perdu!");
            }
        }
    }
}

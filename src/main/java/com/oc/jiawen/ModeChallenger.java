package com.oc.jiawen;

import java.util.Arrays;
import java.util.Scanner;

public class ModeChallenger extends PlayMode {
    public static void main(String[] args) {

        ModeChallenger mc = new ModeChallenger();
        //mc.askDevMode();
        //mc.askSecretNb();
        mc.askPlayOrNot();

    }

    @Override
    public void askSecretNb() {
        Human attackerHuman = new Human();
        Computer attackerComputer = new Computer();
        InputChecker inputChecker = new InputChecker();
        Scanner sc = new Scanner(System.in);

        String inputStr="";
        String winOrLose="";
        int nbRound=0;
        int[] tabRandom = attackerComputer.giveRandomNb();

        guessInLoop(attackerHuman, attackerComputer, inputChecker, sc, inputStr, winOrLose, nbRound, tabRandom);

    }

    public void guessInLoop(Human attackerHuman, Computer attackerComputer, InputChecker inputChecker, Scanner sc, String inputStr, String winOrLose, int nbRound,int[] tabRandom){
        do {
            //Vérifier si la taille de saisie est bien 4
            do {
                System.out.println("Saissisez 4 chiffres");
                inputStr = sc.nextLine();

            } while (inputStr.length() != 4);

            int[] tabInt = attackerHuman.replyFourDigit(inputStr);
            String[] tabHint = new String[4];
            for (int i = 0; i < 4; i++) {
                tabHint[i] = inputChecker.compareInput(tabInt[i], tabRandom[i]);
                if (tabHint[i].equals("=")) {
                    winOrLose += "=";
                }
            }
            if(winOrLose.length()!=4){
                winOrLose="";
            }

            System.out.println("Proposition : " + inputStr + " -> Réponse: " + Arrays.toString(tabHint));
            System.out.println("la variable de winOrLose is_"+winOrLose);
            nbRound++;
        }while(!winOrLose.contains("====") && nbRound<10);

        if(winOrLose.contains("====")){
            System.out.println("Bravo! Vous avez gagné en "+ nbRound + " tour(s)." );
        }else{
            if(nbRound==10){
                System.out.println("Dommage!! Vous avez perdu!");
            }
        }
    }
}

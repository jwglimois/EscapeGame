package com.oc.jiawen;

import java.util.Arrays;
import java.util.Scanner;

public class ModeChallenger extends PlayMode {
    public static void main(String[] args) {
        /*
        String compt ="";
        int i=0;
        do{
            compt= compt+"a";
            i++;
        }while(i<4);
        System.out.println(compt);
         if(compt.contains("aaaa")){

             System.out.println("C'est bon, length compte: "+compt.length());

         }else{
             System.out.println("KO length compte: "+compt.length());
         }

         */


        ModeChallenger mc = new ModeChallenger();
        mc.askSecretNb();


    }

    @Override
    public void askSecretNb() {
        Human attackerHuman = new Human();
        Computer attackerComputer = new Computer();
        InputChecker inputChecker = new InputChecker();
        Scanner sc = new Scanner(System.in);

        String inputStr;
        String winOrLose="";
        int nbRound=0;
        int[] tabRandom = attackerComputer.giveRandomNb();
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

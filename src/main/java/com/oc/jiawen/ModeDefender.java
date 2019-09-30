package com.oc.jiawen;

import java.util.Scanner;

public class ModeDefender extends PlayMode {

    public static void main(String[] args) {
        ModeDefender md= new ModeDefender();
        //md.askSecretNb();
        String[] tabStr = md.askInputHint();
        for(String i : tabStr){
            System.out.println(i);
        }
    }

    @Override
    protected void askSecretNb() {
        Human defenderHuman = new Human();
        Computer attackerComputer = new Computer();
        InputChecker inputChecker = defenderHuman.getInputChecker();
        String nbComputer="";
        String inputStr = this.askInput4Digit();


        int[] tabIntComputer = attackerComputer.giveRandomNb();
        for(int i = 0; i<tabIntComputer.length ; i++){
            nbComputer = nbComputer +tabIntComputer[i];
        }
        this.guessInLoop(inputStr, nbComputer, inputChecker, tabIntComputer);


    }


    public void guessInLoop(String inputStr, String nbComputer, InputChecker inputChecker, int[] tabIntComputer){
        int nbRound=0;
        do{
            System.out.println("[Machine] : Votre nombre secret est-il bien :" + nbComputer +"?");
            int winOrNot= inputChecker.checkInputOneOrZero();
            nbRound++;
            if(winOrNot==1){
                System.out.println("[Machine]: Yes!! J'ai gagné!!");
            }else{
                for(int i=0 ; i<tabIntComputer.length ; i++){
                    tabIntComputer[i]=Integer.parseInt(Character.toString(nbComputer.charAt(i)));
                }
                System.out.println("[Machine]: Peux-tu me donner quelques indices en saisissant 4 symboles? Saisissez '+' pour dire 'plus', '-' pour dire 'moins' et '=' pour 'égal'.");
            }
            String[] tabHint = this.askInputHint();
            nbComputer="";

            for(int j=0; j<tabIntComputer.length ; j++){
                int result = inputChecker.compareInputHint(tabHint[j], tabIntComputer[j]);
                if(result<10 && result>=0){
                    nbComputer = nbComputer + result;
                }else{
                    System.out.println("Vous avez donné les mauvaises indices. Merci de recommencer le jeu ");
                    System.exit(0);
                }

            }

        }while(!inputStr.equals(nbComputer) && nbRound<10);
        System.out.println("[Machine] : Mince! 10 fois d'essai atteint!!  J'ai perdu!!");

    }

    public String[] askInputHint(){
        Scanner input = new Scanner(System.in);
        String[] tabHint = new String[4];
        boolean isValid;
        String hint="";
        do{
            System.out.println("Saisissez 4 symboles. 3 possibilités: '+' , '-', et '='.");
            hint = input.next();
            int goodSymbols=0;
            if(hint.length() == 4){
                for (int i = 0; i < hint.length(); i++) {
                    tabHint[i] = String.valueOf(hint.charAt(i));
                    if( tabHint[i].equals("=") || tabHint[i].contains("+") || tabHint[i].contains("-")) {
                        goodSymbols++;
                    }
                }
                if(goodSymbols==4){
                    isValid = true;
                }else{
                    System.out.println("Erreur!! Vous avez saisi les caractères non autorisés");
                    isValid = false;
                }
            }else{
                System.out.println("Vous avez saisi plus ou moin de 4 caractères.");
                isValid = false;
            }

        }while(!(isValid));

        return tabHint;
    }

}

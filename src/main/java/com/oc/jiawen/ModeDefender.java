package com.oc.jiawen;

import java.util.Scanner;

public class ModeDefender extends PlayMode {

    public static void main(String[] args) {
        ModeDefender md= new ModeDefender();
        md.askSecretNb();

    }

    @Override
    protected void askSecretNb() {
        Human defenderHuman = new Human();
        Computer attackerComputer = new Computer();
        InputChecker inputChecker = defenderHuman.getInputChecker();
        String inputStr = this.askInput4Digit();
        this.guessInLoop(attackerComputer, inputStr, inputChecker);

    }


    public void guessInLoop(Computer attackerComputer, String inputStr, InputChecker inputChecker){
        boolean stopGame;
        boolean machineGain;
        int nbRound=0;
        String strComputer="";
        int[] tabIntComputer = attackerComputer.giveRandomNb();
        for(int i = 0; i<tabIntComputer.length ; i++){
            strComputer = strComputer +tabIntComputer[i];
        }
        do{
            if(!inputStr.equals(strComputer)){
                if(nbRound<10){
                    System.out.println("[Machine] : Votre nombre secret est-il bien :" + strComputer +"? Si non, Donnez moi quelques indices. Saisissez '+' pour dire 'plus', '-' pour dire 'moins' et '=' pour 'égal'. ");
                    for(int i = 0; i<strComputer.length() ; i++){
                        tabIntComputer[i] = Integer.parseInt(Character.toString(strComputer.charAt(i)));
                    }
                    String[] tabHint = this.askInputHint();

                    //On vide strComputer afin de remettre la nouvelle combinaison
                    strComputer="";
                    for(int j=0; j<tabIntComputer.length ; j++){
                        int result = inputChecker.compareInputHint(tabHint[j], tabIntComputer[j]);
                        if(result<10 && result>=0){
                            strComputer = strComputer + result;
                        }else if (result==10){
                            strComputer = strComputer + 9;
                        }else{
                            strComputer = strComputer + 0;
                        }
                    }
                    nbRound++;
                    stopGame = false;
                }else{
                    System.out.println("[Machine] : 10 essais atteints. J'ai perdu.");
                    stopGame = true;
                }
                machineGain = false;
            }else{
                nbRound++;
                System.out.println("[Machine] : J'ai trouvé, c'est bien " + strComputer + "? Saisir 1 pour Oui et 0 pour Non.");
                int confirmWin = inputChecker.checkInputOneOrZero();
                if(confirmWin ==1){
                    stopGame=true;
                }else{
                    System.out.println("Ah bon? Tu n'as pas triché??");
                    stopGame=true;
                }
                machineGain = true;
            }
        }while(!(stopGame));

        System.out.println("La bonne réponse est "+ inputStr + ".");

        if(machineGain){
            System.out.println("La machine a gagné en " + nbRound + " tours.");
        }


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

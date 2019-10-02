package com.oc.jiawen;

import java.util.Arrays;

public class ModeDuel extends PlayMode {


    /**
     * askSecretNb() est une fonction héritée depuis la classe abstraite. Elle sert à interagir avec l'utilisateur en lui demandant de deviner dans les boucles.
     */
    @Override
    protected void askSecretNb() {
        Human human = new Human();
        Computer computer = new Computer();
        InputChecker inputChecker = human.getInputChecker();
        System.out.println("[Arbitre]: Vous ête en Mode Duel. Le joueur humain commence à deviner la combinaison secréte.");
        int[] tabReponse = computer.giveRandomNb();
        this.guessInLoop( inputChecker, tabReponse) ;

    }

    /**
     * guessInLoop() permet de juger si l'utilisateur ou l'ordinateur a gagné ou pas en passant plusieurs conditions. En cas de perte d'une partie, on repasse la devinette jusqu'à ce que 10 tours sont atteints.
     * @param inputChecker La 1ère valeur d'entrée est un objet de type InputChecker appelé par un objet Human.
     * @param tabReponse La 2ème valeur d'entrée est une liste de 4 nombres entiers qui représentent la réponse de l'arbitre générée par la méthode giveRandomNb().
     */
    public void guessInLoop(InputChecker inputChecker, int[] tabReponse){
        boolean stopGame;
        int[] tabInput = new int[4];
        String[] tabHint = new String[4];
        String strInput, strHint;
        int nbRound=0;
        do {
            if (nbRound < 10) {
                strInput = inputChecker.checkInput4Digit();
                nbRound++;
                strHint="";
                for(int i=0; i<strInput.length() ; i++){
                    tabInput[i] = Integer.parseInt(Character.toString(strInput.charAt(i)));
                    tabHint[i]  = inputChecker.compareInputInt(tabInput[i], tabReponse[i]);
                    strHint = strHint + tabHint[i];
                }
                if(strHint.equals("====")){
                    System.out.println("[Arbitre] : Human a gagné en "+nbRound+ " tour(s).");
                    stopGame=true;
                }else{
                    System.out.println("[Arbitre] : Non, voici les indices: "+ Arrays.toString(tabHint));
                    // C'est la machine qui devine.
                    strInput="";
                    strHint="";
                    for(int j=0; j<tabInput.length ; j++){
                        tabInput[j] = inputChecker.compareInputHint(tabHint[j] ,tabInput[j]);
                        tabHint[j]  = inputChecker.compareInputInt(tabInput[j], tabReponse[j]);
                        strInput = strInput + tabInput[j];
                        strHint = strHint + tabHint[j];
                    }
                    System.out.println("[Machine] : C'est bien " + strInput + " ?");
                    nbRound++;
                    if(strHint.equals("====")){
                        System.out.println("[Arbitre] : Machine a gagné en "+nbRound+ " tour(s).");
                        stopGame=true;
                    }else{
                        System.out.println("[Arbitre] : Non, voici les indices: "+ Arrays.toString(tabHint));
                        stopGame=false;
                    }
                }
            }else{
                System.out.println("[Arbitre] : 10 fois d'essai atteint. Le jeu est fini!");
                stopGame=true;
            }
        }while(!(stopGame));
    }


}

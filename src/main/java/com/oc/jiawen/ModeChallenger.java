package com.oc.jiawen;

import java.util.Arrays;

public class ModeChallenger extends PlayMode {

    /**
     * askSecretNb() est une fonction héritée depuis la classe abstraite. Elle sert à interagir avec l'utilisateur en lui demandant de deviner dans les boucles.
     */
    @Override
    public void askSecretNb() {
        Human attackerHuman = this.getUser();
        Computer defenderComputer = this.getMachine();
        InputChecker inputChecker = attackerHuman.getInputChecker();

        String hint="";
        int nbRound=0;
        int[] tabRandom = defenderComputer.giveRandomNb();

        guessInLoop(attackerHuman, inputChecker, hint, nbRound, tabRandom);

    }

    /**
     * guessInLoop() permet de juger si l'utilisateur a gagné ou pas en passant plusieurs conditions. En cas de perte, on repasse la devinette jusqu'à ce que 10 tours sont atteints.
     * @param attackerHuman La 1ère valeur d'entrée est un objet de type Human.
     * @param inputChecker La 2ème valeur d'entrée est un objet de type InputChecker
     * @param hint La 3ème valeur d'entrée est un String pour réprésente l'indice
     * @param nbRound La 4ème valeur d'entrée est le nombre de tours en int
     * @param tabRandom La 5lème valeur d'entrée est un tableau de int contenant le chiffre généré aléatoirement par la méthode giveRandomNb().
     */
    public void guessInLoop(Human attackerHuman, InputChecker inputChecker,  String hint, int nbRound,int[] tabRandom){
        do {
            String inputStr="";
            int[] tabInt = attackerHuman.replyFourDigit();
            String[] tabHint = new String[4];
            for (int i = 0; i < 4; i++) {
                inputStr = inputStr + tabInt[i];
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

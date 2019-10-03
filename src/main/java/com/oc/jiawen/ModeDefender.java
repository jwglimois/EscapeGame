package com.oc.jiawen;

public class ModeDefender extends PlayMode {

    /**
     * askSecretNb() est une fonction héritée depuis la classe abstraite. Elle sert à interagir avec l'utilisateur en lui demandant de deviner dans les boucles.
     */
    @Override
    protected void askSecretNb() {
        Human defenderHuman = this.getUser();
        InputChecker inputChecker = defenderHuman.getInputChecker();
        String inputStr = inputChecker.checkInput4Digit();

        Computer attackerComputer = this.getMachine();

        this.guessInLoop(inputChecker , inputStr,  attackerComputer );

    }

    /**
     * guessInLoop() permet de juger si l'ordinateur a gagné ou pas en passant plusieurs conditions. En cas de perte, on repasse la devinette jusqu'à ce que 10 tours sont atteints.
     * @param inputChecker La 1ère valeur d'entrée est un objet de type InputChecker appelé par un objet Human.
     * @param inputStr La 2ème valeur d'entrée est un String qui contient la saisie de 4 chiffres de l'utilisateur.
     * @param attackerComputer La 3ème valeur d'entrée est un objet de type Computer.
     */
    public void guessInLoop(InputChecker inputChecker, String inputStr, Computer attackerComputer){
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
                    String[] tabHint = inputChecker.checkInputHint();

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
                    System.out.println("[Machine] : Ah bon? Tu n'as pas triché??");
                    stopGame=true;
                }
                machineGain = true;
            }
        }while(!(stopGame));

        System.out.println("[Arbitre] : La bonne réponse est "+ inputStr + ".");

        if(machineGain){
            System.out.println("[Arbitre] : La machine a gagné en " + nbRound + " tours.");
        }

    }



}

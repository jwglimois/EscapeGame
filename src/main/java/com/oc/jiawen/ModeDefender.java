package com.oc.jiawen;

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
        String inputStr = inputChecker.askInput4Digit();
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
                    String[] tabHint = attackerComputer.getInputChecker().askInputHint();

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

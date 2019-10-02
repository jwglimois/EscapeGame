package com.oc.jiawen;

public class Human extends Player{


    /**
     * replyNewPlayMode() permet de recupérer le playMode de l'utilisateur vérifié par la classe InputChecker.
     * @return un nombre entier. 3 possibilités: 1, 2, et 3
     */
    public int replyNewPlayMode(){

        int newPlayMode = this.getInputChecker().checkInputNextPlayMode();
        return newPlayMode;
    }

    /**
     * reply1or0() permet de recupérer la réponse de l'utilisateur en int.
     * @return la valeur de retour est soit 1, soit 0 en Int.
     */
    public int reply1or0(){
        int oneOrZero = this.getInputChecker().checkInputOneOrZero();
        return oneOrZero;
    }

    /**
     * replyFourDigit() permet à l'utilisateur de saisir 4 chiffres qui seront vérifés dans la classe InputChecker
     * @return int[] - On convertit le string et retourne un tableau int.
     */

   public int[] replyFourDigit(){
       String inputStr = this.getInputChecker().checkInput4Digit();
       int[] tbInputIn = new int[4];
       for(int i = 0; i<tbInputIn.length ; i++){
           tbInputIn[i] = Integer.parseInt(Character.toString(inputStr.charAt(i)));
       }

       return tbInputIn;

   }





}

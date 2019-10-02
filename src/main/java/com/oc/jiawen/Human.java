package com.oc.jiawen;

public class Human extends Player{


    public static void main(String[] args) {


        Human h = new Human();
        InputChecker ic = h.getInputChecker();


    }

    /**
     * l'utilisateur saisie 4 chiffres qui ont été vérifés par les méthodes de la classe InputChecker
     * @param myString Le paramètre d'entrée est un String
     * @return int[] - On convertit le string et retourne un tableau int.
     */

   public int[] replyFourDigit(String myString){
       InputChecker ic = new InputChecker();
       int[] tbInputIn = new int[4];
       for(int i = 0; i<tbInputIn.length ; i++){
           tbInputIn[i] = Integer.parseInt(Character.toString(myString.charAt(i)));
       }

       return tbInputIn;

   }




}

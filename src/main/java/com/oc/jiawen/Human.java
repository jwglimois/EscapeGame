package com.oc.jiawen;

public class Human extends Player{


    public static void main(String[] args) {


        Human h = new Human();
        InputChecker ic = h.getInputChecker();


        /*
        InputChecker ic= new InputChecker();
        String result = ic.compareInput(2,1);
        System.out.println("Mon resultat est :"+ result);

         */
    }

    /**
     * l'utilisateur saisie 4 chiffres qui ont été vérifés par les méthodes de la classe InputChecker
     * @param myString Le paramètre d'entrée est un String
     * @return int[] - On convertit le string et retourne un tableau int.
     */

   public int[] replyFourDigit(String myString){
       InputChecker ic = new InputChecker();

       //Vérifier si on peut convertir les chiffresString en int
       //Si ok, on met les chiffres dans un tableau
       int[] tbInputIn = new int[4];
       if(ic.nbStringConvertToInt(myString)){
           tbInputIn=ic.nbStrConvertToTabInt(myString);
       }else{
           System.out.println("Erreur de mettre les chiffres dans le tableau!");
       }

       return tbInputIn;


   }




}

package com.oc.jiawen;

public class Human extends Player{

    public static void main(String[] args) {
        Human h = new Human();
        int[] tabTest=h.replyFourDigit("1234");
        System.out.println("Notre tab est :" + tabTest[0]);
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
           System.out.println("Erreurs!");
       }

       return tbInputIn;


   }




}

package com.oc.jiawen;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class InputChecker {

    public static void main(String[] args) {

        InputChecker ic = new InputChecker();
        ic.checkIfOneOrZero();
    }



    /**
     * Vérifier si les chiffres saisies sont bien en nombre entier.
     * @param nbStr String
     * @return boolean
     */
    public boolean nbStringConvertToInt(String nbStr){
        try{
            int inputInt = Integer.parseInt(nbStr);
            return inputInt > 0;
        }catch(NumberFormatException e){
            System.out.println("Seul les chiffres entiers sont acceptés!!");
            return false;
        }
    }

    /**
     * Retourner les chiffresString en un tableau de nombres entiers.
     * @param nbStr String
     * @return int[]
     */
    public int[] nbStrConvertToTabInt(@NotNull String nbStr) {
        int[] tabInputInt = new int[nbStr.length()];
        for(int i=0; i<nbStr.length();i++){
            tabInputInt[i]=Integer.parseInt(Character.toString(nbStr.charAt(i)));
        }
        return tabInputInt;
    }

    /**
     * Comparer 2 chiffres entiers puis donner les indices pour la devinette.
     * @param inputAttacker int
     * @param inputDefender int
     * @return les indices en string : = pour équalité ; + pour plus; - pour moins
     */
    public String compareInput(int inputAttacker, int inputDefender){
        if(inputAttacker == inputDefender){
            return "=";
        }else if(inputAttacker > inputDefender){
            return "-";
        }else{
            return "+";
        }
    }

    public void checkIfOneOrZero(){
        String nbStr;
        do{
            System.out.println("Saisir 1 pour Oui, 0 pour Non.");
            Scanner sc = new Scanner(System.in);
            nbStr = sc.next();

            System.out.println("Vous avez saisir:"+nbStr);
            System.out.println("Longeur est:"+nbStr.length());

        }while(!isValidInputOneOrZero(nbStr));

    }

    /**
     *
     * @param input La saisie d'utilisateur qui doit être soit 1 soit 0.
     * @return boolean - Si la saisie est validé, on retourne true.
     */
    public boolean isValidInputOneOrZero(String input)
    {
        // La longeur doit être 1
        if(input.length() != 1)
            return false;

        // Si c'est un nombre entier
        try
        {
            Integer i = Integer.parseInt(input);
            if(i>1)
                return false;
        }
        catch(NumberFormatException e)
        {
            return false;
        }

        // Tous les arguments précédents sont passés, la saisie est donc validée.
        return true;
    }




}

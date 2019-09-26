package com.oc.jiawen;

import org.jetbrains.annotations.NotNull;

public class InputChecker {

    public static void main(String[] args) {

        InputChecker ic = new InputChecker();
        String str=ic.compareInput(1, 2);
        System.out.println("Notre resultat est :" + str);
    }

    private int nbOneDigit;
    private int[] nbFourDigit = new int[4];

    public int getNbOneDigit() {
        return nbOneDigit;
    }
    public void setNbOneDigit(int nbOneDigit) {
        this.nbOneDigit = nbOneDigit;
    }

    public int[] getNbFourDigit() {
        if(nbFourDigit.length==4){
            return nbFourDigit;
        }else{
            System.out.println("Length is :"+nbFourDigit.length);
            return nbFourDigit;
        }
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
    public void setNbFourDigit(int[] nbFourDigit) {
        this.nbFourDigit = nbFourDigit;
    }

    public void checkInputLengthBeFour(){


    }



}

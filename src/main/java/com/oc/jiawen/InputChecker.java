package com.oc.jiawen;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class InputChecker {

    public static void main(String[] args) {

        InputChecker ic = new InputChecker();
        int monChiffre = ic.checkInputNextPlayMode();
        System.out.println("Mon next mode est :"+ monChiffre);
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

    /**
     * Vérifier si la saisie de l'utilisateur est bien 1 ou 0.
     * @return La valeur de retour doit être un entier, soit 1 soit 0.
     */
    public int checkInputOneOrZero(){
        String nbStr;
        do{
            System.out.println("Saisir 1 pour Oui ; 0 pour Non");
            Scanner sc = new Scanner(System.in);
            nbStr = sc.next();
            System.out.println("Vous avez saisi: " + nbStr);
        }while(!nbStr.equals("0") && !nbStr.equals("1"));


        int nbInt;
        try {
            nbInt = Integer.parseInt(nbStr);
            return nbInt;
        } catch (NumberFormatException e) {
            System.out.println("Erreur de convertir une chaine de caractères en nombre entier!!");
            return nbInt=0;
        }

    }

    /**
     * Vérifier si la saisie de l'utilisateur est bien 1 ou 2 ou 3.
     * @return La valeur de retour doit être un entier. Seulement 3 possibilité: 1, 2, ou 3.
     */

    public int checkInputNextPlayMode(){
        int nbInt=0;
        boolean isNb = true;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Seulement 3 possibilités: 1, 2, ou 3.");
            if(!input.hasNextInt()){
                System.out.println("Vous devez saisir un chiffre!!");
                input.next();
                isNb=false;
            }else{
                nbInt= input.nextInt();
                if(nbInt<=3 && nbInt>=1){
                    isNb=true;
                }else{
                    System.out.println("Votre saisie n'entre pas dans les réponses possibles (1,2, ou 3).");
                    isNb=false;
                }
            }
        }while(!(isNb));
        return nbInt;
    }








}

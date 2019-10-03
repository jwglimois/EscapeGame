package com.oc.jiawen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class InputChecker {

    /**
     * On utilise un objet de Logger pour générer les logs des fonctions de la classe InputChecker.
     */
    private static Logger logger = LogManager.getLogger(InputChecker.class);

    /**
     * checkInputNextPlayMode() permert de vérifier si la saisie de l'utilisateur est bien 1 ou 2 ou 3.
     * @return La valeur de retour doit être un entier. Seulement 3 possibilité: 1, 2, ou 3.
     */
    public int checkInputNextPlayMode(){
        int nbInt=0;
        boolean isNb;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Vous avez seulement 3 possibilités: 1, 2, ou 3.");
            if(!input.hasNextInt()){
                System.out.println("Vous devez saisir un chiffre!!");
                input.next();
                isNb=false;
            }else{
                nbInt= input.nextInt();
                if(nbInt<=3 && nbInt>=1){
                    isNb=true;
                }else{
                    logger.error("Votre saisie '"+nbInt+ "' n'entre pas dans les réponses possibles (1,2, ou 3).");
                    isNb=false;
                }
            }
        }while(!(isNb));
        return nbInt;
    }


    /**
     * checkInput4Digit() permet de vérifier si la saisie de l'utilisateur est bien 4 nombres entiers.
     * @return Si ok, on convertir notre chiffre en String
     */
    protected String checkInput4Digit(){
        Scanner sc = new Scanner(System.in);
        //Vérifier si la taille de saisie est bien 4
        boolean is4Digit;
        int inputInt=0;
        String inputStr = "";
        do{
            System.out.println("Saissisez un nombre secrét de 4 chiffres");
            if (sc.hasNextInt()) {
                inputStr = sc.next();
                //inputStr=String.valueOf(inputInt);
                if(inputStr.length()==4){
                    is4Digit = true;
                }else{
                    logger.error("Vous avez saisi une combinaison '" + inputStr + "', elle compose > ou < 4 chiffres.");
                    is4Digit = false;
                }
            } else {
                inputStr=sc.next();
                logger.error("Vous avez saisi une combinaison '" + inputStr + "', ce qui ne doit pas être caractères!!");
                is4Digit = false;
            }
        } while (!(is4Digit));
        return inputStr;
    }


    /**
     * compareInputInt() permet de comparer 2 chiffres entiers puis donner les indices pour la devinette.
     * @param inputAttacker int
     * @param inputDefender int
     * @return les indices en string : = pour équalité ; + pour plus; - pour moins
     */
    public String compareInputInt(int inputAttacker, int inputDefender){
        if(inputAttacker == inputDefender){
            return "=";
        }else if(inputAttacker > inputDefender){
            return "-";
        }else{
            return "+";
        }
    }


    /**
     * compareInputHint() permet de comparer les indices "+, - ou =" avec la chiffre entrant, puis retourner une nouveau chiffre généré en respectant l'indice donnée.
     * @param symbole La 1ère valeur d'entrée est un String qui doit être "+, - ou =".
     * @param nbAComparer la 2ème valeur d'entrée un nombre entier qu'on compare avec les indices.
     * @return La valeur de retour est le resultat de comparaison en int.
     */
    public int compareInputHint(String symbole, int nbAComparer){
        if(symbole.equals("+")){
            nbAComparer++;
        }
        if(symbole.equals("-")) {
            nbAComparer--;
        }
        return nbAComparer;
    }

    /**
     * checkInputHint() permet à l'utilisateur de saisir les indices. Cette fonction n'est utilisé que dans le mode Défenseur.
     * @return la valeur de retour est une liste de String en 4 caractères qui ne répresentent que "+, - ou =".
     */
    public String[] checkInputHint(){
        Scanner input = new Scanner(System.in);
        String[] tabHint = new String[4];
        boolean isValid;
        String hint="";
        do{
            System.out.println("Saisissez 4 symboles. 3 possibilités: '+' , '-', et '='.");
            hint = input.next();
            int goodSymbols=0;
            if(hint.length() == 4){
                for (int i = 0; i < hint.length(); i++) {
                    tabHint[i] = String.valueOf(hint.charAt(i));
                    if( tabHint[i].equals("=") || tabHint[i].contains("+") || tabHint[i].contains("-")) {
                        goodSymbols++;
                    }
                }
                if(goodSymbols==4){
                    isValid = true;
                }else{
                    logger.error("Erreur!! Vous avez saisi les caractères non autorisés");
                    isValid = false;
                }
            }else{
                logger.error("Vous avez saisi plus ou moin de 4 caractères.");
                isValid = false;
            }

        }while(!(isValid));

        return tabHint;
    }


    /**
     * checkInputOneOrZero() permet de vérifier si la saisie de l'utilisateur est bien 1 ou 0.
     * @return La valeur de retour doit être un nombre entier, soit 1 soit 0.
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
            logger.error("Vous avez saisi '" + nbStr + "' . Ce qui n'est pas un nombre entier!!");
            return nbInt=0;
        }

    }






}

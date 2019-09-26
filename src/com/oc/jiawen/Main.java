package com.oc.jiawen;

import java.io.*;
import java.util.*;

import static java.lang.String.*;


public class Main {

    public static void main(String[] args) {
        //askDevMode();
        //guessSecretNb();
        ModeChallenger modeChallenger = new ModeChallenger();
        modeChallenger.runGame();
    }

    /**
     * Simuler le mode Challenger
     */
    private static void guessSecretNb() {
        System.out.println("Devinez la combinaison secréte en 4 chiffres.");
        Scanner sc = new Scanner(System.in);
        int[] tabInput = new int[4];
        String inputStr;
        //Vérifier la taille de saisie
        do{
            System.out.println("Saissisez 4 chiffres");
            inputStr = sc.nextLine();

        }while(inputStr.length()!=4);

        //Vérifier si la saisie est un nombre entier
        try{
            int inputInt = Integer.parseInt(inputStr);
            System.out.println("Vous avez bien saisir les nombres:"+inputInt);
        }catch(NumberFormatException e){
            System.out.println("Seul les chiffres entiers sont acceptés!!");
        }

        //Comparer la combinaison secréte avec la saisie
        Random objRandom = new Random();
        int[] tabRandom = new int[inputStr.length()];
        int[] tabInputInt = new int[inputStr.length()];
        StringBuilder bonReponse = new StringBuilder();
        String[] tabReponse = new String[4];

        for(int i=0; i<inputStr.length();i++){
            tabRandom[i]=objRandom.nextInt(10);
            bonReponse.append(""+tabRandom[i]);
            tabInputInt[i]=Integer.parseInt(Character.toString(inputStr.charAt(i)));

            if(tabInputInt[i]==tabRandom[i]){
                tabReponse[i]="=";
            }else if (tabInputInt[i]>tabRandom[i]){
                tabReponse[i]="-";
            }else{
                tabReponse[i]="+";
            }
        }
        System.out.println("Proposition : "+inputStr + "-> Réponse:" + Arrays.toString(tabReponse));
        System.out.format("La bonne réponse est:%s\n", bonReponse);
    }

    /**
     * L'utilisateur doit décider s'il veut activer le mode Développeur ou pas
     *
     */
    private static void askDevMode() {
        // Initier notre paramétrage modeDev = true
        setProperties();

        Scanner sc = new Scanner(System.in);
        System.out.println("Pour activer le mode Développeur, tappez 1, sinon d'autres chiffres");

        // Pour modifier le paramétrage du modeDev, l'utilisateur saisit 1 ou les autres réponses
        int isDevInt;
        try{
            isDevInt=sc.nextInt();
            String isDevString;
            if(isDevInt!=1){
                isDevString = "false";
            }else {
                isDevString="true";
            }

            //Modifier config.properties avec le modeDev saisie par l'utilisateur
            updateModeDev(isDevString);

            //afficher tous nos paramétrages
            displayProperties();
        }catch(InputMismatchException e){
            System.out.println("Oups, vous ne pouvez que saisir les chiffres entiers entre 0 et 9");
            System.exit(0);
        }

    }


    /**
     * l'utilisateur met à jour le modeDev dans le ficher config.properties
     */
    private static void updateModeDev(String modeDevString) {
        Boolean modeDevBool = Boolean.valueOf(modeDevString);
        Properties props = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream("config.properties");
            props.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            System.out.println("Oops, on n'arrive pas à télécharger le fichier config.properties!"); 
        }

        FileOutputStream out;
        try {
            out = new FileOutputStream("config.properties");
            props.setProperty("modeDeveloper", valueOf(modeDevBool));
            props.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            System.out.println("Oops, on n'arrive pas à télécharger le fichier config.properties!");
        }
    }

    /**
     * On affiche tous les paramétrages indiqués dans config.properties.
     */
    private static void displayProperties() {

        try {
            InputStream inputConfigFile = new FileInputStream("config.properties");
            Properties properties = new Properties();

            // load the config.properties file
            properties.load(inputConfigFile);

            // get the property value and print it out
            System.out.println("Nom de projet: "+properties.getProperty("project-name"));
            System.out.println("Mode de développeur activé: " + properties.getProperty("modeDeveloper"));
            System.out.println("Nombre de chiffres de la combinaison: " +properties.getProperty("nbDigit"));
            System.out.println("Nombre d'essais du jeu: " + properties.getProperty("nbRound"));
        } catch (FileNotFoundException e) {
            System.out.println("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            System.out.println("Oops, on n'arrive pas à télécharger le fichier config.properties!");
        }
        //modeDevBool=Boolean.getBoolean();
    }

    /**
     * On met les paramétrages initiaux dans config.properties.
     */
    private static void setProperties() {
        Properties properties = new Properties();
        properties.setProperty("project-name", "EscapeGame");
        properties.setProperty("nbDigit", "4");
        properties.setProperty("nbRound", "10");
        properties.setProperty("modeDeveloper", "true");
        FileWriter writer = null;
        try {
            writer = new FileWriter("config.properties");
            properties.store(writer, "Author: Jiawen");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer !=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}

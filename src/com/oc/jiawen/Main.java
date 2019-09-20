package com.oc.jiawen;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initier notre paramétrage modeDev = true
        setProperties();

        Scanner sc = new Scanner(System.in);
        System.out.println("Pour activer le mode Développeur, tappez 1, sinon d'autres chiffres");

        // Pour modifier le paramétrage du modeDev, l'utilisateur saisit 1 ou les autres réponses
        int isDevInt=sc.nextInt();
        String isDevString ="";
        if(isDevInt!=1){
            isDevString = "false";
        }else {
            isDevString="true";
        }
        sc.close();

        //Modifier config.properties avec le modeDev saisie par l'utilisateur
        updateModeDev(isDevString);

        //afficher tous nos paramétrages
	    displayProperties();
    }

    /**
     * l'utilisateur met à jour le modeDev dans le ficher config.properties
     * @param modeDevString
     */
    private static void updateModeDev(String modeDevString) {
        Boolean modeDevBool = Boolean.valueOf(modeDevString);
        Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("config.properties");
            props.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            System.out.println("Oops, on n'arrive pas à télécharger le fichier config.properties!"); 
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream("config.properties");
            props.setProperty("modeDeveloper", String.valueOf(modeDevBool));
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

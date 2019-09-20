package com.oc.jiawen;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
	    //setProperties();
	    getProperties();
    }

    private static void getProperties() {
        boolean modeDevBool;
        int nbDigitInt, nbRoundInt;

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

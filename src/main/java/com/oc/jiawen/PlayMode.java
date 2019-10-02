package com.oc.jiawen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.String.valueOf;

public abstract class PlayMode {

    private static Logger logger = LogManager.getLogger(PlayMode.class);
    private Human user = new Human();

    /**
     * getUser() est un Getter permettant de récupérer l'attribut user qui est un objet Human
     * @return La valeur de retour est le type Human
     */
    protected Human getUser() {
        return user;
    }

    /**
     * RunGame() comprend plusieurs fonctions qui permettent de parcourir le jeu depuis la saisie de modeDev jusau'au choix de re-jouer.
     * @return La valeur de retour est un booléen.
     */
    protected boolean runGame(){
        askDevMode();
        informGameRules();
        askSecretNb();
        boolean reply = askPlayOrNot();
        return reply;
    }

    /**
     * display3PlayModes() est une fonction qui affiche le mode d'emploi de 3 modes de jeu.
     */
    protected void display3PlayModes(){
        System.out.println("Choisissez votre mode de jeu.");
        System.out.println("1 pour Mode Challenger. C'est-à-dire que l'utilisateur est l'attaquant, et la machine est le défenseur.");
        System.out.println("2 pour Mode Défenseur. C'est-à-dire que l'utilisateur est le défenseur, et la machine est l'attaquant'.");
        System.out.println("3 pour Mode Duel. C'est-à-dire que l'utilisateur et la machine jouent tour à tour'.");
    }

    /**
     * informGameRules() affiche la régle du jeu: la saisie de 4 chiffres et 10 fois d'essai.
     */
    protected void informGameRules(){
        System.out.println("Devinez la combinaison secréte en 4 chiffres. 10 fois d'essai possible.");
    }

    protected abstract void askSecretNb();

    /**
     * askDevMode() permet à l'utilisateur de décider s'il veut activer le mode Développeur ou pas.
     */
    protected void askDevMode(){
        // Initier notre paramétrage modeDev = true
        initializeProperties();

        Scanner sc = new Scanner(System.in);
        System.out.print("Pour activer le mode Développeur.");

        // Pour modifier le paramétrage du modeDev, l'utilisateur saisit 1 ou les autres réponses
        int isDevInt = this.getUser().reply1or0();

        //Modifier config.properties avec le modeDev saisie par l'utilisateur
        updateModeDev(isDevInt);

        //afficher tous nos paramétrages
        displayProperties();
    }

    /**
     * initializeProperties() met les paramétrages initiaux dans config.properties.
     */
    protected void initializeProperties(){
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

    /**
     * updateModeDev() permet à l'utilisateur de mettre à jour le modeDev dans le ficher config.properties
     * @param  isDevInt la valeur d'entrée est un nombre entier qui représente 1 (activer le mode Dev) ou 0 (désactiver le mode Dev).
     */
    protected void updateModeDev(int isDevInt){
        Boolean modeDevBool = (isDevInt == 1);
        Properties props = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream("config.properties");
            props.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            logger.error("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            logger.error("Oops, on n'arrive pas à télécharger le fichier config.properties!");
        }

        FileOutputStream out;
        try {
            out = new FileOutputStream("config.properties");
            props.setProperty("modeDeveloper", valueOf(modeDevBool));
            props.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            logger.error("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            logger.error("Oops, on n'arrive pas à télécharger le fichier config.properties!");
        }
    }

    /**
     * displayProperties() permet d'afficher tous les paramétrages indiqués dans config.properties.
     */
    protected void displayProperties(){
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
            logger.error("Oops, on n'arrive pas à trouver le fichier config.properties");
        } catch (IOException e) {
            logger.error("Oops, on n'arrive pas à télécharger le fichier config.properties!");
        }
    }

    /**
     * Demander à l'utilisateur s'il veut encore jouer encore ou pas. 1 pour Oui et 0 pour Non.
     * @return La valeur de retour est un booléen qui réprésente si l'utilisateur veut rejouer (true) ou non (false).
     */
    protected boolean askPlayOrNot(){
        System.out.println("Voulez-vous jouer encore? ");
        int reply = this.getUser().reply1or0();
        if(reply==1){
            System.out.println("Ok, c'est parti, notre nouveau tour!");
            return true;
        }else{
            System.out.println("C'était un plaisir de jouer avec toi. Au revoir!");
            return false;
        }

    }







}

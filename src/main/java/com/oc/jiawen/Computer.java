package com.oc.jiawen;

import java.util.Random;

public class Computer extends Player{


    /**
     * giveRandomNb() permet de récupérer une combinaison de 4 chiffres avec l'objet Random.
     * @return La valeur de retour est une liste en int
     */
    public int[] giveRandomNb(){
        Random objRandom = new Random();
        int[] tabRandom = new int[4];
        for(int i=0; i<4;i++){
            tabRandom[i]=objRandom.nextInt(10);
        }
        return tabRandom;
    }
}

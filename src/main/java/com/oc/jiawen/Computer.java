package com.oc.jiawen;

import java.util.Random;

public class Computer extends Player{

    public static void main(String[] args) {
        Computer com = new Computer();
        int[] monTab = com.giveRandomNb();
        System.out.println(monTab[0]);
    }

    public int[] giveRandomNb(){
        Random objRandom = new Random();
        int[] tabRandom = new int[4];
        for(int i=0; i<4;i++){
            tabRandom[i]=objRandom.nextInt(10);
        }
        return tabRandom;
    }
}

package com.oc.jiawen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HumanTest {

    @Test
    void Given_nbString_WhenConvertToTabInt_ThenGetTrue() {
        Human human = new Human();
        //Si c'est un tableau;
        assertTrue(human.replyFourDigit("1234").getClass().isArray());

        //Si le tableau ne contient que les nombres entiers
        assertTrue(human.replyFourDigit("1234").getClass().getSuperclass().equals(Number.class));
    }


}
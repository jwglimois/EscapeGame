package com.oc.jiawen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputCheckerTest {


    @Test
    void Given_Input_LengthShouldBeFour(){
        InputChecker inputChecker = new InputChecker();
        assertEquals(4,inputChecker.getNbFourDigit().length );
    }

    @Test
    void Given_nbString_IfSucceedConvertToInt_ThenGetTrue() {
        InputChecker inputChecker = new InputChecker();
        assertTrue(inputChecker.nbStringConvertToInt("1234"));
    }

    @Test
    void Given_nbStr_WhenConvertToTabInt_ThenGetTrue() {
        InputChecker inputChecker = new InputChecker();
        assertTrue(inputChecker.nbStrConvertToTabInt("1234").getClass().isArray());
    }

    @Test
    void Given_InputAttacker_Equals_InputDefender_WhenEqual_ThenGetStringEven() {
        InputChecker inputChecker = new InputChecker();
        assertEquals("=" ,inputChecker.compareInput(1,1) );
    }

    @Test
    void Given_InputAttacker_GreaterThen_InputDefender_WhenEqual_ThenGetStringLess() {
        InputChecker inputChecker = new InputChecker();
        assertEquals("-" ,inputChecker.compareInput(2,1) );
    }

    @Test
    void Given_InputAttacker_SmallerThen_InputDefender_WhenEqual_ThenGetStringPlus() {
        InputChecker inputChecker = new InputChecker();
        assertEquals("+" ,inputChecker.compareInput(1,2) );
    }
}
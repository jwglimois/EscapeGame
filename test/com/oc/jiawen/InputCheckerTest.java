package com.oc.jiawen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputCheckerTest {

    @Test
    void Given_InputAttacker_Equals_InputDefender_ThenGetStringEven() {
        InputChecker inputChecker = new InputChecker();
        assertEquals("=" ,inputChecker.compareInputInt(1,1) );
    }

    @Test
    void Given_InputAttacker_GreaterThen_InputDefender_ThenGetStringLess() {
        InputChecker inputChecker = new InputChecker();
        assertEquals("-" ,inputChecker.compareInputInt(2,1) );
    }

    @Test
    void Given_InputAttacker_SmallerThen_InputDefender_ThenGetStringPlus() {
        InputChecker inputChecker = new InputChecker();
        assertEquals("+" ,inputChecker.compareInputInt(1,2) );
    }


    @Test
    void Give_InputSymbol_InputAttacker_WhenSymbolIsPlus_ThenIncremetInputAttacker() {
        InputChecker inputChecker = new InputChecker();
        assertEquals(2, inputChecker.compareInputHint("+", 1));
    }

    @Test
    void Give_InputSymbol_InputAttacker_WhenSymbolIsMinus_ThenDecremetInputAttacker() {
        InputChecker inputChecker = new InputChecker();
        assertEquals(1, inputChecker.compareInputHint("-", 2));
    }

    @Test
    void Give_InputSymbol_InputAttacker_WhenSymbolIsEqual_ThenDecremetInputAttacker() {
        InputChecker inputChecker = new InputChecker();
        assertEquals(2, inputChecker.compareInputHint("=", 2));
    }
}
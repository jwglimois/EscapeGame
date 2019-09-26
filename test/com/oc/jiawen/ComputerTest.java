package com.oc.jiawen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void SetRandomNb_WhenGetTabInt_ThenGetTrue() {
        Computer com = new Computer();
        assertTrue(com.giveRandomNb().getClass().isArray());
    }
}
package com.wonit.notifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlackNotificatorTest {

    SlackNotificator sut;


    @BeforeEach
    void setUp() {
        sut = new SlackNotificator();
    }

    @Test
    void name() {
        sut.execute();
    }
}
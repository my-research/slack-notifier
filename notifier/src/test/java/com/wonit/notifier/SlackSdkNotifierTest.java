package com.wonit.notifier;

import com.wonit.notifier.model.NotifyMessage;
import com.wonit.notifier.model.SendingTypes;
import com.wonit.notifier.slack.SlackSdkNotifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlackSdkNotifierTest {

    SlackSdkNotifier sut;


    @BeforeEach
    void setUp() {
        sut = new SlackSdkNotifier();
    }

    @Test
    void name() {
        sut.execute(new NotifyMessage(SendingTypes.SLACK_PROGRAMMING, "hello"));
    }
}
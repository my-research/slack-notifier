package com.wonit.notifier;

import com.wonit.notifier.domain.Message;
import com.wonit.notifier.domain.SendingTypes;
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
        sut.execute(Message.of(SendingTypes.SLACK_PROGRAMMING, "hello"));
    }
}
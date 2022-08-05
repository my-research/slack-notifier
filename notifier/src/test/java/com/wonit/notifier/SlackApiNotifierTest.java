package com.wonit.notifier;

import com.wonit.notifier.domain.Message;
import com.wonit.notifier.domain.SendingTypes;
import com.wonit.notifier.slack.SlackApiNotifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class SlackApiNotifierTest {
    SlackApiNotifier sut;

    @BeforeEach
    void setUp() {
        sut = new SlackApiNotifier(new RestTemplate());
    }

    @Test
    void name() {
        sut.execute(new Message(SendingTypes.SLACK_HTTP, "this is api"));
    }
}
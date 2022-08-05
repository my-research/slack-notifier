package com.wonit.notifier;

import com.wonit.notifier.model.NotifyMessage;
import com.wonit.notifier.model.SendingTypes;
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
        sut.execute(new NotifyMessage(SendingTypes.SLACK_HTTP, "this is api"));
    }
}
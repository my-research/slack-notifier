package com.wonit.notifier;

import com.slack.api.Slack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlackNotificator implements Notificator {
    @Override
    public void execute() {
        Slack slack = Slack.getInstance();

        slack.
    }
}

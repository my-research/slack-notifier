package com.wonit.notifier.config;

import com.wonit.notifier.Notifier;
import com.wonit.notifier.slack.NotifierDispatcher;
import com.wonit.notifier.slack.SlackApiNotifier;
import com.wonit.notifier.slack.SlackSdkNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotifierConfig {

    @Bean
    public Notifier notifierDispatcher(SlackApiNotifier apiNotifier,
                                       SlackSdkNotifier sdkNotifier) {

        NotifierDispatcher container = new NotifierDispatcher();
        container.register(apiNotifier);
        container.register(sdkNotifier);
        return container;
    }
}

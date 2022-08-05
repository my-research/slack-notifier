package com.wonit.notifier;

import com.wonit.notifier.slack.SlackApiNotifier;
import com.wonit.notifier.slack.SlackNotifierDispatcher;
import com.wonit.notifier.slack.SlackSdkNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Notifier slackNotifierDispatcher(SlackApiNotifier apiNotifier,
                                             SlackSdkNotifier sdkNotifier) {

        SlackNotifierDispatcher container = new SlackNotifierDispatcher();
        container.register(apiNotifier);
        container.register(sdkNotifier);
        return container;
    }
}

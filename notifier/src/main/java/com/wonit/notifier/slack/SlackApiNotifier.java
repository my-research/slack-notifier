package com.wonit.notifier.slack;

import static com.wonit.notifier.model.SendingTypes.SLACK_HTTP;

import com.wonit.notifier.Notifier;
import com.wonit.notifier.model.NotifyMessage;
import com.wonit.notifier.model.SendingTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class SlackApiNotifier implements Notifier {

    @Value("${notifier.slack.webhook_url}")
    private String INCOMING_WEBHOOK_URL;
    private final RestTemplate rest;

    @Override
    public String execute(NotifyMessage message) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<NotifyMessage> request = new HttpEntity<>(message, headers);

        return rest.postForObject(INCOMING_WEBHOOK_URL, request, String.class);
    }

    @Override
    public boolean isSupport(NotifyMessage message) {
        return SLACK_HTTP.equals(message.getType());
    }
}

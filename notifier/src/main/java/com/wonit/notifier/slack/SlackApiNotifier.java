package com.wonit.notifier.slack;

import static com.wonit.notifier.domain.SendingTypes.SLACK_HTTP;

import com.wonit.notifier.AbstractNotifier;
import com.wonit.notifier.domain.Message;
import com.wonit.notifier.domain.Specification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SlackApiNotifier extends AbstractNotifier {

    private static final Specification supportSpec = Specification.of(SLACK_HTTP);

    @Value("${notifier.slack.webhook_url}")
    private String INCOMING_WEBHOOK_URL;
    private final RestTemplate rest;

    public SlackApiNotifier(RestTemplate rest) {
        super(supportSpec);
        this.rest = rest;
    }

    @Override
    public String execute(Message message) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Message> request = new HttpEntity<>(message, headers);

        return rest.postForObject(INCOMING_WEBHOOK_URL, request, String.class);
    }
}

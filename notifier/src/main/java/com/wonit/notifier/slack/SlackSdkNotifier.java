package com.wonit.notifier.slack;

import static com.wonit.notifier.domain.SendingTypes.SLACK_PROGRAMMING;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.wonit.notifier.AbstractNotifier;
import com.wonit.notifier.Notifier;
import com.wonit.notifier.domain.Message;
import com.wonit.notifier.domain.Specification;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SlackSdkNotifier extends AbstractNotifier {

    private static final Specification supportSpec = Specification.of(SLACK_PROGRAMMING);

    @Value("${notifier.slack.oauth_token}")
    private String OAUTH_TOKEN;
    private static final String SLACK_CHANNEL = "C03SCN9RW4V";

    public SlackSdkNotifier() {
        super(supportSpec);
    }

    @Override
    public String execute2(Message message) {
        Slack slack = Slack.getInstance();

        try {
            MethodsClient methods = slack.methods(OAUTH_TOKEN);
            ChatPostMessageRequest request = ChatPostMessageRequest.builder().channel(SLACK_CHANNEL)
                    .text(message.getText()).build();
            ChatPostMessageResponse response = methods.chatPostMessage(request);
            if (response.isOk()) {
                return "ok";
            }
            return "error";
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
            return "error";
        }
    }
}

package com.wonit.notifier;

import com.wonit.notifier.model.NotifyMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final Notifier slackNotifierContainer;

    @PostMapping("/api/message")
    public ResponseEntity<String> sendMessage(@RequestBody NotifyMessage message) {
        String response = slackNotifierContainer.execute(message);
        return ResponseEntity.ok(response);
    }
}

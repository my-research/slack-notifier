package com.wonit.notifier;

import com.wonit.notifier.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final Notifier notifierDispatcher;

    @PostMapping("/api/message")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        String response = notifierDispatcher.execute(message);
        return ResponseEntity.ok(response);
    }
}

package com.wonit.notifier.model;

import com.wonit.notifier.domain.SendingTypes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendMessageRequest {
    private SendingTypes type;
    private String content;
}

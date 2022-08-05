package com.wonit.notifier.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Specification {
    SendingTypes type;

    public boolean isSatisfy(Message message) {
        return message.getType().equals(type);
    }
}

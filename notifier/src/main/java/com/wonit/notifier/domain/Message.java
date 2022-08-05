package com.wonit.notifier.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Message {
    SendingTypes type;
    String text;
}

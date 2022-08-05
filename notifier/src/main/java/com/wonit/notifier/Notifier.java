package com.wonit.notifier;

import com.wonit.notifier.domain.Message;

public interface Notifier {
    String execute(Message message);
    boolean isSupport(Message message);
}

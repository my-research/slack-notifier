package com.wonit.notifier;

import com.wonit.notifier.model.NotifyMessage;

public interface Notifier {
    String execute(NotifyMessage message);
    boolean isSupport(NotifyMessage message);
}

package com.wonit.notifier.slack;

import com.wonit.notifier.Dispatcher;
import com.wonit.notifier.Notifier;
import com.wonit.notifier.domain.Message;
import java.util.ArrayList;
import java.util.List;

public class NotifierDispatcher implements Dispatcher {

    private final List<Notifier> containers = new ArrayList<>();

    @Override
    public String execute(Message message) {
        Notifier notifier = containers.stream()
                .filter(n -> n.isSupport(message))
                .findFirst()
                .orElseThrow();
        return notifier.execute(message);
    }

    @Override
    public boolean isSupport(Message message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void register(Notifier notifier) {
        if (containers.contains(notifier)) {
            throw new IllegalArgumentException();
        }
        containers.add(notifier);
    }
}


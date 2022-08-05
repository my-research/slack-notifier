package com.wonit.notifier.slack;

import com.wonit.notifier.Notifier;
import com.wonit.notifier.Registrar;
import com.wonit.notifier.model.NotifyMessage;
import java.util.ArrayList;
import java.util.List;

public class SlackNotifierDispatcher implements Notifier, Registrar {

    private final List<Notifier> containers = new ArrayList<>();

    @Override
    public String execute(NotifyMessage message) {
        Notifier notifier = containers.stream()
                .filter(n -> n.isSupport(message))
                .findFirst()
                .orElseThrow();
        return notifier.execute(message);
    }

    @Override
    public boolean isSupport(NotifyMessage message) {
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

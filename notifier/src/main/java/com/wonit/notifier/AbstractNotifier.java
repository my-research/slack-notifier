package com.wonit.notifier;

import com.wonit.notifier.Notifier;
import com.wonit.notifier.domain.Message;
import com.wonit.notifier.domain.Specification;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractNotifier implements Notifier {

    private final Specification supportSpec;

    @Override
    public boolean isSupport(Message message) {
        return supportSpec.isSatisfy(message);
    }
}

package com.wonit.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
public interface Notificator {
    void execute();
}

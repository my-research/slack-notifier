package com.wonit.notifier;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class WebApplicationTests {

    @Autowired
    ApplicationContext sut;

    @Test
    void contextLoads() {
        String[] beanNames = sut.getBeanDefinitionNames();

        assertThat(beanNames).contains("notificator");
    }

}

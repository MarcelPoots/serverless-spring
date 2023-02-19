package com.example.serverlessspringboot.config;

import com.example.serverlessspringboot.model.Subscriber;
import com.example.serverlessspringboot.service.SubscriberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class SubscriberConfig {

    private final SubscriberService subscriberService;

    public SubscriberConfig(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @Bean
    public Consumer<String> create() {
        return (email) -> subscriberService.create(email);
    }

    @Bean
    public Supplier<List<Subscriber>> findAll() {
        return () -> subscriberService.findAll();
    }
}

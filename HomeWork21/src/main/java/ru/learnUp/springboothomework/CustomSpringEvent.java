package ru.learnUp.springboothomework;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {
    private final String event;

    public CustomSpringEvent(Object source, String event) {
        super(source);
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
package com.example.touchingawss3.events;

import org.springframework.context.ApplicationEvent;

import java.util.Properties;

public class ChangeS3ConnectionPropertiesEvent extends ApplicationEvent {

    public ChangeS3ConnectionPropertiesEvent(Properties newProps) {
        super(newProps);
    }
}

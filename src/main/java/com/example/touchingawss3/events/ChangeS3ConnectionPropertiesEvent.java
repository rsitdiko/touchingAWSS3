package com.example.touchingawss3.events;

import org.springframework.context.ApplicationEvent;

public class ChangeS3ConnectionPropertiesEvent extends ApplicationEvent {

    public ChangeS3ConnectionPropertiesEvent(String justString) {
        super(justString);
    }
}

package com.example.touchingawss3.publisher;

import com.example.touchingawss3.events.ChangeS3ConnectionPropertiesEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ChangeS3PropertiesPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(ChangeS3PropertiesPublisher.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent() {
        LOG.info("\n--- Публикую событие...");
        ChangeS3ConnectionPropertiesEvent event = new ChangeS3ConnectionPropertiesEvent(new Properties());
        applicationEventPublisher.publishEvent(event);
    }
}

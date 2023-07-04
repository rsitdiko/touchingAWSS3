package com.example.touchingawss3.listener;

import com.example.touchingawss3.events.ChangeS3ConnectionPropertiesEvent;
import com.example.touchingawss3.manager.S3ClientManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ChangeS3PropertiesListener implements ApplicationListener<ChangeS3ConnectionPropertiesEvent> {
    private static final Log LOG = LogFactory.getLog(ChangeS3PropertiesListener.class);

    @Override
    public void onApplicationEvent(ChangeS3ConnectionPropertiesEvent event) {
        LOG.info("\n--- Listening for changes...");
        LOG.info("\n--- New property is " + event.getSource());
        new S3ClientManager().updateActualS3Client((Properties) event.getSource());
    }
}

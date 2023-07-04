package com.example.touchingawss3.publisher;

import com.example.touchingawss3.publisher.ChangeS3PropertiesPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChangeS3PropertiesPublisherTest {

    @Autowired
    private ChangeS3PropertiesPublisher publisher;

    @Test
    void publishEvent() {
        publisher.publishEvent();
    }
}
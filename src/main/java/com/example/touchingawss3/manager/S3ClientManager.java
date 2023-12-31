package com.example.touchingawss3.manager;

import com.example.touchingawss3.collection.FixedLengthQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;

import javax.annotation.PostConstruct;
import java.util.Properties;

public class S3ClientManager {
    private static final Log LOG = LogFactory.getLog(S3ClientManager.class);

    @Value("${s3/access-key}")
    private String accessKey;

    @Value("${s3/secret-key}")
    private String secretKey;

    private FixedLengthQueue<S3Client> clients;

    public Object getS3Client() {
        return clients.get();
    }

    public void updateActualS3Client(Properties properties) {
        LOG.info("\n Updating S3Client... ");

        AwsBasicCredentials credentials = AwsBasicCredentials
                .create(properties.getProperty("access-key"),
                        properties.getProperty("secret-key")
                );

        S3Client newClient = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        if (!isS3ClientValid(newClient)) {
            LOG.error("\n --- New S3Client properties are not valid...");
            return;
        }

        clients.add(newClient);
        LOG.info("\n S3Client updated... ");
    }

    private boolean isS3ClientValid(S3Client client) {
        try {
            client.listBuckets();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostConstruct
    private void init() {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        S3Client client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        clients.add(client);
    }


}

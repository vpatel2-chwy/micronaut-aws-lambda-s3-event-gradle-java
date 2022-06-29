package example.micronaut;

import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import io.micronaut.core.annotation.Introspected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Introspected
public class MicronautRequestHandler
        extends io.micronaut.function.aws.MicronautRequestHandler<S3Event, Void> { // <1>
    private static final Logger LOG = LoggerFactory.getLogger(MicronautRequestHandler.class);

//    @Inject
//    public AmazonS3 s3Client; // <2>

    @Override
    public Void execute(S3Event input) {
        LOG.info("S3 Event: {}", input);

        for (S3EventNotification.S3EventNotificationRecord record : input.getRecords()) {

            LOG.info("event name: {}" , record.getEventName());
        }
        return null;
    }
}

package example.micronaut;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class S3RequestHandler implements
        RequestHandler<S3Event, Void> {
    private static final Logger LOG = LoggerFactory.getLogger(S3RequestHandler.class);

    @Override
    public Void handleRequest(S3Event input, Context context) {
        LOG.info("S3 Event: {}", input);

        for (S3Event.S3EventNotificationRecord record : input.getRecords()) {

            LOG.info("event name: {}" , record.getEventName());
        }
        return null;
    }
}


package example.micronaut;

import com.amazonaws.lambda.thirdparty.com.google.gson.Gson;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.amazonaws.services.lambda.runtime.serialization.PojoSerializer;
import com.amazonaws.services.lambda.runtime.serialization.events.LambdaEventSerializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StringS3RequestHandler implements
        RequestHandler<Map<String,String>, Void> {
    private static final Logger LOG = LoggerFactory.getLogger(StringS3RequestHandler.class);

    @Override
    public Void handleRequest(Map<String,String> input, Context context) {
        LOG.info("S3 Event: {}", input);

        PojoSerializer<S3EventNotification> s3EventSerializer =
                LambdaEventSerializers.serializerFor(S3EventNotification.class, ClassLoader.getSystemClassLoader());


        S3EventNotification eventNotification = s3EventSerializer.fromJson(new Gson().toJson(input));

        for (S3Event.S3EventNotificationRecord record : eventNotification.getRecords()) {

            LOG.info("event name: {}" , record.getEventName());
        }
        return null;
    }
}


package example.micronaut;

import com.amazonaws.lambda.thirdparty.com.google.gson.Gson;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.amazonaws.services.lambda.runtime.serialization.PojoSerializer;
import com.amazonaws.services.lambda.runtime.serialization.events.LambdaEventSerializers;
import io.micronaut.core.annotation.Introspected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Introspected
public class HackyMicronautRequestHandler extends io.micronaut.function.aws.MicronautRequestHandler<S3EventNotification, Void> { // <1>
    private static final Logger LOG = LoggerFactory.getLogger(HackyMicronautRequestHandler.class);

//    @Inject
//    public AmazonS3 s3Client; // <2>

    @Override
    public Void execute(S3EventNotification input) {
        for (S3EventNotification.S3EventNotificationRecord record : input.getRecords()) {

            LOG.info("event name: {}" , record.getEventName());
        }
        return null;
    }

    @Override
    protected S3EventNotification convertInput(Object object){
        String input = new Gson().toJson(object);
        LOG.info("OBJECT: {}", input);

        PojoSerializer<S3EventNotification> s3EventNotificationPojoSerializer = LambdaEventSerializers.serializerFor(S3EventNotification.class, S3EventNotification.class.getClassLoader());
        return s3EventNotificationPojoSerializer.fromJson(input);
    }
}

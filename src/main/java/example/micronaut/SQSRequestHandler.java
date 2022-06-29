package example.micronaut;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Introspected
public class SQSRequestHandler
        extends MicronautRequestHandler<SQSEvent, Void> { // <1>
    private static final Logger LOG = LoggerFactory.getLogger(SQSRequestHandler.class);

//    @Inject
//    public AmazonS3 s3Client; // <2>

    @Override
    public Void execute(SQSEvent input) {
        for (SQSEvent.SQSMessage record : input.getRecords()) {

            LOG.info("event body: {}" , record.getBody());
        }
        return null;
    }
}

## Micronaut deserialization error resolution

In this [sample project](https://guides.micronaut.io/latest/micronaut-aws-lambda-s3-event-gradle-java.html) we have added a custom serializer to mitigate the `jackson deserialization error`. Micronaut dependency injection works just fine with SQS, and standard lambda request handlers - but gives `deserialization errors` in the case of S3Events.

Please refer to `HackyMicronautRequestHandler` in contrast to `MicronautRequestHandler` to see the work-around with our custom serialization.

## Micronaut 3.5.2 Documentation

- [User Guide](https://docs.micronaut.io/3.5.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.5.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.5.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Handler

[AWS Lambda Handler](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)

Handler: example.micronaut.MicronautRequestHandler


- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature aws-lambda documentation

- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)


## Feature aws-v2-sdk documentation

- [Micronaut AWS SDK 2.x documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/)

- [https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html)



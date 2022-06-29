FROM amazon/aws-lambda-java:11 AS app

WORKDIR /app

COPY ./build/classes/java/main ${LAMBDA_TASK_ROOT}
COPY ./build/dependency/* ${LAMBDA_TASK_ROOT}/lib/
COPY ./build/resources/* ${LAMBDA_TASK_ROOT}/resources/

EXPOSE 8080

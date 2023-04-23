FROM openjdk:11
ADD target/kafka-0.0.1-SNAPSHOT.jar kafka-consumer
ENTRYPOINT ["java", "-jar", "kafka-consumer"]
EXPOSE  8045
Start Zookeper

Use the below command to start the Zookeeper service:
# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

# Windows command:
bin/windows/zookeeper-server-start.bat config/zookeeper.properties

Start Kafka Broker

Open another terminal session and run the below command to start the Kafka broker:
# Start the Kafka broker service

# Linux command
bin/kafka-server-start.sh config/server.properties

# Windows command:
bin/windows/kafka-server-start.bat config/server.properties

# Run with Docker
- Use 'cd' command to go to the folder of the project and run the command:
- Execute: [mvn clean install]

    - build docker file
      [docker build -t kafka-consumer .]
    - run dockerfile
      [docker run -p8045:8045 kafka-consumer]
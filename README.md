# kafka-demo

### Setup

* Start zookeeper
* Start Kafka Server (3 kafka servers)
* Create a topic (topic name: topic5) with partitions 10 and replication factor of 3

**PS: Revisit the properties in IKafkaConstants.java if required.**

### Steps to run code

* Run Consumer using command: **java -cp kafkademo-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.jazz.kafkademo.main.MainConsumer**

* Run Producer using command: **java -cp kafkademo-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.jazz.kafkademo.main.MainProducer**

**PS: Run multiple consumers to see how partitionaing works.**
package com.jazz.kafkademo.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;

import com.jazz.kafkademo.constants.IKafkaConstants;
import com.jazz.kafkademo.partitioner.CustomPartitioner;
import com.jazz.kafkademo.pojo.CustomObject;
import com.jazz.kafkademo.serializer.CustomSerializer;

public class ProducerCreator {
	public static Producer<Long, CustomObject> createProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKER);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, IKafkaConstants.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IKafkaConstants.KEY_SERIALIZER);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, IKafkaConstants.VALUE_SERIALIZER);
		props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, IKafkaConstants.PARTITIONER_CLASS);
		return new KafkaProducer<Long, CustomObject>(props);
	}
}

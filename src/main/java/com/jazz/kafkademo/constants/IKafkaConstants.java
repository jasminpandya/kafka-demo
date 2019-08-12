package com.jazz.kafkademo.constants;

import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;

import com.jazz.kafkademo.deserializer.CustomDeserializer;
import com.jazz.kafkademo.partitioner.CustomPartitioner;
import com.jazz.kafkademo.serializer.CustomSerializer;

public interface IKafkaConstants {
	public static String KAFKA_BROKER = "localhost:9092,localhost:9093";
	public static String CLIENT_ID = "client1";
	public static String TOPIC_NAME = "topic5";
	public static Integer PARTITION_COUNT = 10;
	public static String GROUP_NAME = "group1";
	public static String KEY_SERIALIZER = LongSerializer.class.getName();
	public static String VALUE_SERIALIZER = CustomSerializer.class.getName();
	public static String KEY_DESERIALIZER = LongDeserializer.class.getName();
	public static String VALUE_DESERIALIZER = CustomDeserializer.class.getName();
	public static String PARTITIONER_CLASS = CustomPartitioner.class.getName();
}

package com.jazz.kafkademo.partitioner;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import com.jazz.kafkademo.constants.IKafkaConstants;
import com.jazz.kafkademo.pojo.CustomObject;

public class CustomPartitioner implements Partitioner {

	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
	}

	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		CustomObject obj = (CustomObject) value;
		Integer keyInt = Integer.valueOf(obj.getId());
		keyInt = keyInt % IKafkaConstants.PARTITION_COUNT;
		return keyInt.intValue();
	}

	public void close() {
		// TODO Auto-generated method stub

	}

}

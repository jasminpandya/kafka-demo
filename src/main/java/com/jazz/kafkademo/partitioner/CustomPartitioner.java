package com.jazz.kafkademo.partitioner;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import com.jazz.kafkademo.constants.IKafkaConstants;
import com.jazz.kafkademo.pojo.CustomObject;

public class CustomPartitioner implements Partitioner {

	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		System.out.println("Inside configure: " + configs.toString());
	}

	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		List<PartitionInfo> availablePartitions = cluster.availablePartitionsForTopic(IKafkaConstants.TOPIC_NAME);
		System.out.println("Available partitions:" + availablePartitions.toString());
		CustomObject obj = (CustomObject) value;
		Integer keyInt = Integer.valueOf(obj.getId());
		keyInt = keyInt % IKafkaConstants.PARTITION_COUNT;
		System.out.println("key => " + keyInt);
		return keyInt.intValue();
	}

	public void close() {
		// TODO Auto-generated method stub

	}

}

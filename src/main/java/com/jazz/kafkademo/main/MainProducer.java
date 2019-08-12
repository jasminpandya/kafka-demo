package com.jazz.kafkademo.main;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.jazz.kafkademo.constants.IKafkaConstants;
import com.jazz.kafkademo.pojo.CustomObject;
import com.jazz.kafkademo.producer.ProducerCreator;

public class MainProducer {
	public static void main(String args[]) {
		Producer<Long, CustomObject> producer = ProducerCreator.createProducer();
		long i = (long) Math.random() * 10000 / 100;
		while (true) {
			CustomObject obj = new CustomObject();
			obj.setId(String.valueOf(i));
			obj.setName("name" + String.valueOf(i));
			try {
				RecordMetadata metadata = producer
						.send(new ProducerRecord<Long, CustomObject>(IKafkaConstants.TOPIC_NAME, obj)).get();
				System.out.println("Offset: " + metadata.offset() + " Partition: " + metadata.partition() + " data: "
						+ obj.toString());
				i += 1;
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

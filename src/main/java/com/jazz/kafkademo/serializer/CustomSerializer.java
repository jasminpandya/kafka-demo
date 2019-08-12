package com.jazz.kafkademo.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jazz.kafkademo.pojo.CustomObject;

public class CustomSerializer implements Serializer<CustomObject> {

	public static Gson gson = new GsonBuilder().create();

	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}

	public byte[] serialize(String topic, CustomObject data) {
//		System.out.println("0-ser");
		byte[] retVal = null;
		if (null != data) {
			retVal = gson.toJsonTree(data).toString().getBytes();
		}
//		System.out.println("1-ser");
		return retVal;
	}

	public void close() {
		// TODO Auto-generated method stub

	}

}

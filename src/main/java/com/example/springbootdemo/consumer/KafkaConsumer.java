package com.example.springbootdemo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.model.User;

@Service
public class KafkaConsumer {

	
	@KafkaListener(topics = "kafka_Producer_Poc" , groupId = "demo_group")
	public void consume(String message){
		System.out.println("Consumed string message :" + message);
	}
	
	@KafkaListener(topics = "kafka_Producer_Poc_Json" , groupId = "demo_group_json" , containerFactory = "KafkaListenerContainerFactoryJson")
	public void consumeJson(User user){
		System.out.println("Consumed json message :" + user.toString());
	}
}

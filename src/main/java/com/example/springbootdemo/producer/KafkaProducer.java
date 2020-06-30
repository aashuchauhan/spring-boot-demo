package com.example.springbootdemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserResource.
 */	
@RestController
@RequestMapping("/kafka")
public class KafkaProducer {		
	
	/** The kafka template. */
	@Autowired
	KafkaTemplate<String , String> kafkaTemplate;
	
	/** The kafka template. */
	@Autowired
	KafkaTemplate<String , User> kafkaTemplateJson;
	
	/** The Constant TOPIC. */
	private static final String TOPIC1 = "kafka_Producer_Poc";
	
	/** The Constant TOPIC. */
	private static final String TOPIC2 = "kafka_Producer_Poc_Json";

	 /**
 	 * Gets the hello.
 	 *
 	 * @return the hello
 	 */
 	@GetMapping("/")
	 public String getHello(){		
		 return "Hello world";
	 }
	 
	 /**
 	 * Produce string message.
 	 *
 	 * @param message the message
 	 * @return the string
 	 */
 	@GetMapping("/publishString/{message}")
	 public String produceStringMessage(@PathVariable("message")final String message){
		 kafkaTemplate.send(TOPIC1 , message);
		 return "Message published";
	 }
 	
 	 /**
 	 * Produce Json message.
 	 *
 	 * @param message the message
 	 * @return the string
 	 */
 	@GetMapping("/publishJson/{name}")
	 public String produceJsonMessage(@PathVariable("name")final String name){
 		kafkaTemplateJson.send(TOPIC2 ,  new User(name, "Technology", 12000L));
		return "Message published";
	 }
	 
	
}

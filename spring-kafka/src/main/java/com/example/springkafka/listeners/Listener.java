package com.example.springkafka.listeners;

import org.springframework.stereotype.Component;

@Component
public class Listener {

  @org.springframework.kafka.annotation.KafkaListener(topics= "kafkaTopic",groupId = "groupId")
  void listen(String data) {
    System.out.println("Data in listen method -> "+data);
  }
	
}

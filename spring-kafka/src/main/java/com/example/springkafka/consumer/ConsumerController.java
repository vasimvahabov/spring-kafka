package com.example.springkafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class ConsumerController {

  @Autowired
  private KafkaTemplate<String,String> _template;
	
  @PostMapping("/publish")
  public void publish(@RequestBody MessageModel messageModel){ 
    this._template.send("kafkaTopic",messageModel.message());
//    publish method executed in ConsumerController....
  }
}

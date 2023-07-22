package com.example.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafkaApplication {
	
  public static void main(String[] args) {
	SpringApplication.run(SpringKafkaApplication.class, args);
  }
  
//  @Bean
//  CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
//    return args->{
////      kafkaTemplate.send("kafkaTopic","Hi kafka .............");
//    	for(int i=0; i<10_000; i++) {
//          kafkaTemplate.send("kafkaTopic",i+" Hi kafka .............");
//    	}
//    }; 
//  }
}

package com.example.springkafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;
  
  public Map<String,Object> producerConfig(){
    Map<String,Object> properties=new HashMap<>();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
    return properties;    
  }
  
  @Bean
  ProducerFactory<String,String> producerFactory(){
    return new DefaultKafkaProducerFactory<>(producerConfig());  
  }
  
  @Bean
  KafkaTemplate<String,String> kafkaTemplate(ProducerFactory<String,String> producerFactory){
    return new KafkaTemplate<>(producerFactory);
  }    
	
}





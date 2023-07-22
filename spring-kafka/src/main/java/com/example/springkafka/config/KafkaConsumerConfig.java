package com.example.springkafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class KafkaConsumerConfig {
 
  @Value("${spring.kafka.bootstrap-servers}")
  public String bootstrapServers;
  
  public Map<String,Object> consumerConfig(){
    Map<String,Object> properties=new HashMap<>();
    properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
    properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
    properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
    return properties;    
  }
  
  @Bean
  ConsumerFactory<String,String> consumerFactory(){
    return new DefaultKafkaConsumerFactory<>(consumerConfig());
  }
  
  @Bean
  KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>>
                    listenerFactory(ConsumerFactory<String,String> consumerFactory){
    ConcurrentKafkaListenerContainerFactory<String,String> factory=
    								   new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory);
    return factory;
  }
  
  
  
}

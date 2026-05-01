package com.example.LogCollectorService.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.LogCollectorService.DTO.LogEvent;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

  @Bean
  public ConsumerFactory<String ,  LogEvent> consumerFactory(){

           //JSON -> Java Object Converter
           JsonDeserializer<LogEvent> deserializer = 
                      new JsonDeserializer<>(LogEvent.class);

           //allow deserialization ...... avoid security error
           deserializer.addTrustedPackages("*");

           //optional but best practice
           deserializer.setRemoveTypeHeaders(false);
           deserializer.setUseTypeMapperForKey(true);

           Map<String , Object> config = new HashMap<>();

           //kafka server address
           config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , "localhost:9092");

           //consumer group
           config.put(ConsumerConfig.GROUP_ID_CONFIG, "log-group");

           //key deserializer (String)
           config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

           //Value Deserializer (Json)
           //config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , JsonDeserializer.class);

           //read old messages if no offset found
           config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG , "earliest");


           return new DefaultKafkaConsumerFactory<>(
                config ,
                new StringDeserializer() ,
                deserializer
        );

  }

      @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LogEvent> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, LogEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        // Connect factory with consumer
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }



}

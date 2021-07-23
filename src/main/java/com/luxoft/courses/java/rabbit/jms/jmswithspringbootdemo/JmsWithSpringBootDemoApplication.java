package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo;

import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.model.ToDo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JmsWithSpringBootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(JmsWithSpringBootDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner sendToDos(@Value("${todo.jms.destination}") String destination,
                                     ToDoProducer producer) {
    return __ ->
               producer.sendTo(destination,
                   new ToDo("workout tomorrow morning!"));
  }
}

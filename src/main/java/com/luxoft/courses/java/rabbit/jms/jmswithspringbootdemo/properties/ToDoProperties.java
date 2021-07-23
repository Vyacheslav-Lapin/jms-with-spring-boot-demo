package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.properties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties("ToDoProperties")
public class ToDoProperties {

  
}

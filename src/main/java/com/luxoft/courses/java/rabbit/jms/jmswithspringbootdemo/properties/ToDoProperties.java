package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("todo.jms")
public class ToDoProperties {

  @Setter
  @NonFinal
  String destination;
}

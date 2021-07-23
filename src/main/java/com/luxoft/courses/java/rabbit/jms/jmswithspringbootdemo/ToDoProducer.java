package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo;

import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.model.ToDo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@SuppressWarnings("ClassCanBeRecord")
public class ToDoProducer {

  JmsTemplate jmsTemplate;

  public void sendTo(String destination, ToDo toDo) {
    jmsTemplate.convertAndSend(destination, toDo);
    log.info("Producer> Message Sent");
  }
}

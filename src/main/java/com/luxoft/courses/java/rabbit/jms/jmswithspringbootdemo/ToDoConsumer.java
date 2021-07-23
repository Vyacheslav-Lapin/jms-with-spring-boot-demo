package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo;

import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.dao.ToDoRepository;
import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.model.ToDo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoConsumer {

  ToDoRepository repository;

  @JmsListener(
      destination = "${todo.jms.destination}",
      containerFactory = "jmsFactory")
  public void processToDo(ToDo todo) {
    log.info("Consumer> {} ", todo);
    val save = repository.save(todo);
    log.info("ToDo created> {}", save);
  }
}

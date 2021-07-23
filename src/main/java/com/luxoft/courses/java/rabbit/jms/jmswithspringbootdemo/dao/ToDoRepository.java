package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.dao;

import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.model.ToDo;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, UUID> {
}

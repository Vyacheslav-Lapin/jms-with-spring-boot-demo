package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.validator;

import com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.model.ToDo;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ToDoValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(ToDo.class);
  }

  @Override
  public void validate(@NotNull Object target,
                       @NotNull Errors errors) {

    //    if (target == null) {
    //      errors.reject(null, "ToDo cannot be null");
    //    } else {
    if (target instanceof ToDo toDo
            && toDo.getDescription().isEmpty())

      //noinspection ConstantConditions
      errors.rejectValue("description", null, "description cannot be null or empty");
    //    }
  }
}

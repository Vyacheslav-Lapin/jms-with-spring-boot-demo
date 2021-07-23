package com.luxoft.courses.java.rabbit.jms.jmswithspringbootdemo.model;
import static lombok.AccessLevel.PRIVATE;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.jetbrains.annotations.Contract;

@Getter
@Entity
@Setter(PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
public class ToDo {

  @Id @GeneratedValue @Column(updatable = false, nullable = false) UUID id;

  @Version int version;

  @NonNull String name;
  
  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object o) {
    return this == o || o != null
                            && Hibernate.getClass(this) == Hibernate.getClass(o)
                            && o instanceof ToDo ToDo
                            && Objects.equals(id, ToDo.id);
  }

  @Override
  public int hashCode() {
    return 2134426647;
  }
}

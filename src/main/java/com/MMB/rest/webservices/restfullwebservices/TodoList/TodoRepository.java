package com.MMB.rest.webservices.restfullwebservices.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository <Todo,Long> {

    List<Todo> getByUserName(String username);
}

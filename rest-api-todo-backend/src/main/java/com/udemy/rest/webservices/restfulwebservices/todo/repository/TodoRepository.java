package com.udemy.rest.webservices.restfulwebservices.todo.repository;

import com.udemy.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUsername(String username);
}


package com.udemy.rest.webservices.restfulwebservices.todo;

import com.udemy.rest.webservices.restfulwebservices.todo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TodoJpaResource {
    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoJpaResource(TodoService todoService,TodoRepository todoRepository) {

        this.todoService = todoService;
        this.todoRepository=todoRepository;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoRepository.findByUsername(username);
    }
    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo retrieveTodo( @PathVariable int id) {
        return todoRepository.findById(id).get();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username, @PathVariable int id,@RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping(path = "/users/{username}/todos")
    public Todo createTodo(@PathVariable String username,@RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId(null);
        todoRepository.save(todo);
//        Todo newTodo = todoService.addTodo(username,todo.getDescription(),todo.getTargetDate(),todo.isDone());
        return todo;
    }

}

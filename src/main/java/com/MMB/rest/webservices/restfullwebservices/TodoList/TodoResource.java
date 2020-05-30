package com.MMB.rest.webservices.restfullwebservices.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://muhammadmb.github.io")

public class TodoResource {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){

        return todoRepository.getByUserName(username);
//        return todoService.findAll();
    }

    @GetMapping("/users/{username}")
    public String getHelloMessage(@PathVariable String username){
        return "Welcome Back "+username;
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable Long id){

        return todoRepository.findById(id).get();
//        return todoService.findIt(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> Delete (@PathVariable String username, @PathVariable Long id){

        todoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> Update (@PathVariable String username, @PathVariable Long id, @RequestBody Todo todo){
        todo.setUserName(username);
        Todo Updatedtodo = todoRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> Update (@PathVariable String username, @RequestBody Todo todo){

        todo.setUserName(username);

        Todo Createdtodo = todoRepository.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Createdtodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
package com.MMB.rest.webservices.restfullwebservices.TodoList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static Long Counter = 0L;

    static {
        todos.add(new Todo( ++Counter,"Muhammad","learn java",false,new Date()));
        todos.add(new Todo( ++Counter,"Muhammad","learn JS",false,new Date()));
        todos.add(new Todo( ++Counter,"Muhammad","learn jQuary",false,new Date()));
        todos.add(new Todo( ++Counter,"Muhammad","learn dance",false,new Date()));
        todos.add(new Todo( ++Counter,"Muhammad","learn sing",false,new Date()));
        todos.add(new Todo( ++Counter,"Muhammad","learn writing",false,new Date()));
    }

    public List<Todo> findAll (){
        return todos;
    }

    public Todo DeleteById (Long Id){
        Todo todo = findIt(Id);

        if(todo == null)
            return null;
        if(todos.remove(todo))
            return todo;
        return null;
    }

    public Todo Save (Todo todo){
            todo.setId(++Counter);
            todos.add(todo);
        return todo;
    }

    public Todo Update(Todo todo){
        if(todo.getId() == -1 || todo.getId() == 0){
            Save(todo);
        }else{
            DeleteById(todo.getId());
            todos.add(todo);
        }return todo;
    }

    public Todo findIt(Long id){
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
package com.learning.learning_first.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learning_first.models.todoModel;
import com.learning.learning_first.services.TodoService;


@RestController

@RequestMapping("/public")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // GET request to fetch all data (same as before)
    @GetMapping("/todos")
    public List<todoModel> getAllData() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public todoModel createTodo(@RequestBody todoModel todo) {
        return todoService.saveTodo(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodoById(@PathVariable String id) {
        todoService.deleteTodoById(id);
    }

    @GetMapping("/todos/{id}")
    public Optional<todoModel> getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);

    }

    @GetMapping("/todos/title/{title}")
    public Optional<todoModel> getTodoByTitle(@PathVariable String title) {
        return todoService.getTodoByTitle(title);
    }
    

}

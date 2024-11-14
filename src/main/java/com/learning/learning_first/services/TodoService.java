package com.learning.learning_first.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.learning_first.Repository.TodoRepository;
import com.learning.learning_first.models.todoModel;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // Retrieve all todos
    public List<todoModel> getAllTodos() {
        return todoRepository.findAll();
    }

    // Retrieve a todo by ID
    public Optional<todoModel> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    // Save a new todo or update an existing one
    public todoModel saveTodo(todoModel todo) {
        return todoRepository.save(todo);
    }

    // Delete a todo by ID
   
    public void deleteTodoById(String id) {
        todoRepository.deleteById(id);
    }

    // Find todos by their completed status
    public List<todoModel> getTodosByCompletedStatus(boolean isActive) {
        return todoRepository.findByisActive(isActive);
    }

    // Find todo by title
    public Optional<todoModel> getTodoByTitle(String title) {
        return todoRepository.findByTitle(title);
    }
}


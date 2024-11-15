package com.learning.learning_first.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learning_first.entities.ApiResponse;
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
    public ResponseEntity<ApiResponse<todoModel>> createTodo(@RequestBody todoModel todo) {

        try {
            todoModel todos = todoService.saveTodo(todo);
            ApiResponse<todoModel> response = new ApiResponse<>(HttpStatus.CREATED.value(), "Success", todos);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<todoModel> response = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Failed",
                    null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<ApiResponse> deleteTodoById(@PathVariable String id) {
        boolean todoIsDeleted = todoService.deleteTodoById(id);

        if (todoIsDeleted) {
            ApiResponse<todoModel> response = new ApiResponse<>(HttpStatus.OK.value(), "Success", null);
            return ResponseEntity.ok(response);

        } else {
            ApiResponse<todoModel> response = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Failed", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<todoModel>> getTodoById(@PathVariable String id) {

        Optional<todoModel> todos = todoService.getTodoById(id);

        if (todos.isPresent()) {
            ApiResponse<todoModel> response = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Success",
                    todos.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<todoModel> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Failed",
                    null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @GetMapping("/todos/title/{title}")
    public ResponseEntity<ApiResponse<todoModel>> getTodoByTitle(@PathVariable String title) {
        Optional<todoModel> todos = todoService.getTodoByTitle(title);
        if (todos.isPresent()) {
            ApiResponse<todoModel> response = new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Success",
                    todos.get());
            return ResponseEntity.ok(response);
        } else {
            ApiResponse<todoModel> response = new ApiResponse<>(
                    HttpStatus.NOT_FOUND.value(),
                    "Failed",
                    null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<ApiResponse<todoModel>> updateTodoById(
            @PathVariable String id,
            @RequestBody todoModel updatedTodo) {
        try {
            // Step 1: Check if the Todo exists
            Optional<todoModel> existingTodo = todoService.getTodoById(id);

            if (existingTodo.isPresent() && existingTodo.get().isIsActive() != false) {
                todoModel todo = existingTodo.get();
                todo.setTitle(updatedTodo.getTitle());
                todo.setDescription(updatedTodo.getDescription());
                todo.setIsActive(updatedTodo.isIsActive());
                todo.setCreatedAt(updatedTodo.getCreatedAt());

                // Step 3: Save the updated Todo
                todoModel savedTodo = todoService.updateTodo(todo);

                // Step 4: Return the updated Todo with HTTP 200 OK
                ApiResponse<todoModel> response = new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Todo updated successfully",
                        savedTodo);
                return ResponseEntity.ok(response);
            } else {
                // Step 5: Return HTTP 404 Not Found if the Todo doesn't exist
                ApiResponse<todoModel> response = new ApiResponse<>(
                        HttpStatus.NOT_FOUND.value(),
                        "Todo not found with id: " + id,
                        null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            // Step 6: Handle any errors with HTTP 400 Bad Request
            ApiResponse<todoModel> response = new ApiResponse<>(
                    HttpStatus.BAD_REQUEST.value(),
                    "Failed to update todo: " + e.getMessage(),
                    null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}

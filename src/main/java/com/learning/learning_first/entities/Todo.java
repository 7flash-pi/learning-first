package com.learning.learning_first.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")  // Specifies the MongoDB collection name
public class Todo {

    @Id  // Marks this field as the unique identifier in the MongoDB document
    private String id;
    private String title;
    private String description;
    private boolean isActive;

    // Default constructor
    public Todo() {}

    // Constructor with parameters (optional, if needed)
    public Todo(String title, String description, boolean isActive) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setisActive(boolean isActive) {
        this.isActive = isActive;
    }
}


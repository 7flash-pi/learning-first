package com.learning.learning_first.models;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;





public class todoModel {

    @NotNull
    private String id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    public todoModel(String id,String title,String description,boolean isActive,LocalDateTime createdAt,LocalDateTime deletedAt){
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.isActive = isActive;

    }

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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    
}

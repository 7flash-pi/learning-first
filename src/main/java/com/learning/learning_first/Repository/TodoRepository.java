package com.learning.learning_first.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learning.learning_first.models.todoModel;


public interface TodoRepository extends MongoRepository<todoModel, String> {

    // Custom query methods can be defined here (e.g., by title)
    List<todoModel> findByisActive(boolean isActive);
    
    Optional<todoModel> findByTitle(String title);
}
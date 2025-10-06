package com.anurag.anurag_portfolio.Repository;

import com.anurag.anurag_portfolio.Entities.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    // You can add custom queries later if needed
}
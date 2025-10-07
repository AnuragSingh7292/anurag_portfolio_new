package com.anurag.anurag_portfolio.Repository;

import com.anurag.anurag_portfolio.Entities.Feedback;
import com.anurag.anurag_portfolio.Entities.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anurag.anurag_portfolio.Entities.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public  interface FeedbackRepository extends MongoRepository<Feedback, String> {
    // You can add custom queries later if needed
}
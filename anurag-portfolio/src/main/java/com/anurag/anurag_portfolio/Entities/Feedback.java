package com.anurag.anurag_portfolio.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "feedback")
public class Feedback {
    @Id
    private String id;
    private String name;
    private String email; // optional
    private String subject;
    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters

    public String getId() { return id;}

    public void setId(String id) {  this.id = id;}
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt;}
}


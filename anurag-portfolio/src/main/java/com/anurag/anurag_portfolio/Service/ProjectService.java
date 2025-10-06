package com.anurag.anurag_portfolio.Service;

import com.anurag.anurag_portfolio.Entities.Project;
import com.anurag.anurag_portfolio.Repository.ProjectRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Save a project
    public Project saveProject(Project project) {
        // Save to database
        return projectRepository.save(project);
    }

    // Get project by ID
    public Project getProjectById(String  id) {
        return projectRepository.findById(id).orElse(null);
    }
}

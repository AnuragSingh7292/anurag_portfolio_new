package com.anurag.anurag_portfolio.Controller;

import com.anurag.anurag_portfolio.Entities.Project;
import com.anurag.anurag_portfolio.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")  // Base path for all endpoints
//@CrossOrigin(origins = "*") // Allow frontend JS (React/Angular/etc.)
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // GET: Return all projects
    @GetMapping("/all")
    public List<Project> getAllProjects() {

        return projectService.getAllProjects();
    }

    // POST: Add new project
    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    // GET: Return single project by id
    @GetMapping("/{id}")
    public Project getProject(@PathVariable String id) {
        return projectService.getProjectById(id);
    }
}

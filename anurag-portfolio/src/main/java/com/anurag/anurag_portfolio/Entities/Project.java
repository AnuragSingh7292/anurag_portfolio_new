package com.anurag.anurag_portfolio.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "projects")
public class Project {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public List<String> getDomain() {
        return domain;
    }

    public void setDomain(List<String> domain) {
        this.domain = domain;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    @Id
    private String id;

    private int projectId;
    private String category;
    private String title;
    private String badge;
    private String shortInfo;
    private String description;
    private List<String> technologies;
    private Links links;              // object, not list
    private List<String> domain;
    private List<String> achievements;
    private Timeline timeline;        // object, not list
    private String status;

    public static class Links {
        private String live;
        private String github;

        public String getGithub() {
            return github;
        }

        public void setGithub(String github) {
            this.github = github;
        }

        public String getLive() {
            return live;
        }

        public void setLive(String live) {
            this.live = live;
        }
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public static class Timeline {
        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        private String startDate;  // String is fine for "Jan-2025"
        private String endDate;
    }
}

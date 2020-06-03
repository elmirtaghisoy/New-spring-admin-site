package com.cb.colorbrain.model;

import javax.persistence.*;

@Entity
public class ProjectCreator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "project_id")
    private Long projectId;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project projectByProjectId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User userByUserId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Project getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(Project projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}

package com.cb.colorbrain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Koordinatorluğun adı daxil edilməyib.")
    private String teamName;
    private String teamDesc;
    private String imgName;
    private boolean active = true;

    @OneToMany(targetEntity = Project.class, mappedBy = "teamId", fetch = FetchType.LAZY)
    private Collection<Project> projectsById;

    @OneToMany(targetEntity = Post.class, mappedBy = "teamId", fetch = FetchType.LAZY)
    private Collection<Post> postsById;

    @OneToMany(targetEntity = User.class, mappedBy = "teamId", fetch = FetchType.LAZY)
    private Collection<User> usersById;

    @OneToMany(targetEntity = Applicant.class, mappedBy = "teamId", fetch = FetchType.LAZY)
    private Collection<Applicant> applicantsById;

    public Team() {
    }

    public Team(String teamName, String teamDesc) {
        this.teamName = teamName;
        this.teamDesc = teamDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }

    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }

    public Collection<Project> getProjectsById() {
        return projectsById;
    }

    public void setProjectsById(Collection<Project> projectsById) {
        this.projectsById = projectsById;
    }

    public Collection<Applicant> getApplicantsById() {
        return applicantsById;
    }

    public void setApplicantsById(Collection<Applicant> applicantsById) {
        this.applicantsById = applicantsById;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", teamDesc='" + teamDesc + '\'' +
                ", imgName='" + imgName + '\'' +
                ", active=" + active +
                ", projectsById=" + projectsById +
                ", postsById=" + postsById +
                ", usersById=" + usersById +
                ", applicantsById=" + applicantsById +
                '}';
    }
}

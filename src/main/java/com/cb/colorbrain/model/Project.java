package com.cb.colorbrain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
public class Project implements Saveable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "team_id")
    private Long teamId;
    private boolean active = true;
    @NotBlank(message = "Layihənin adı daxil edilməyib.")
    private String header;
    private String context;
    private String imgName;
    private LocalDateTime date;
    private int status = 1;

    public Project() {
    }

    public Project(Long projectId, Long teamId, String header, String context, LocalDateTime date) {
        this.id = projectId;
        this.teamId = teamId;
        this.header = header;
        this.context = context;
        this.date = date;
    }

    public Project(Long teamId, String header, String context, LocalDateTime date) {
        this.teamId = teamId;
        this.header = header;
        this.context = context;
        this.date = date;
    }

    @OneToMany(targetEntity = ParticipantStatistic.class, mappedBy = "projectId")
    private List<ParticipantStatistic> participantStatisticsById;

    @OneToMany(targetEntity = ProjectCreator.class, mappedBy = "projectId")
    private List<ProjectCreator> projectCreatorsById;

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team teamByTeamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    public Collection<ProjectCreator> getProjectCreatorsById() {
        return projectCreatorsById;
    }

    public void setProjectCreatorsById(List<ProjectCreator> projectCreatorsById) {
        this.projectCreatorsById = projectCreatorsById;
    }

    public Collection<ParticipantStatistic> getParticipantStatisticsById() {
        return participantStatisticsById;
    }

    public void setParticipantStatisticsById(List<ParticipantStatistic> participantStatisticsById) {
        this.participantStatisticsById = participantStatisticsById;
    }

    @Override
    public void setFileNameToObject(String filename) {
        setImgName(filename);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", active=" + active +
                ", header='" + header + '\'' +
                ", context='" + context + '\'' +
                ", imgName='" + imgName + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", participantStatisticsById=" + participantStatisticsById +
                ", projectCreatorsById=" + projectCreatorsById +
                ", teamByTeamId=" + teamByTeamId +
                '}';
    }
}

package com.cb.colorbrain.model;

import javax.persistence.*;

@Entity
public class ParticipantStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "participant_Id")
    private Long participantId;
    @Column(name = "project_id")
    private Long projectId;
    private boolean active;


    @ManyToOne
    @JoinColumn(name = "participant_Id", insertable = false, updatable = false)
    private Participant participantByParticipantId;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project projectByProjectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
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

    public Participant getParticipantByParticipantId() {
        return participantByParticipantId;
    }

    public void setParticipantByParticipantId(Participant participantByParticipantId) {
        this.participantByParticipantId = participantByParticipantId;
    }

    public Project getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(Project projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }
}

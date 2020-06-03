package com.cb.colorbrain.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String seriaId;
    private String email;
    private String phone;
    private Long projectId;
    private int status;
    private boolean active;

    @OneToMany(targetEntity = ParticipantStatistic.class, mappedBy = "participantId")
    private Collection<ParticipantStatistic> participantStatisticsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSeriaId() {
        return seriaId;
    }

    public void setSeriaId(String seriaId) {
        this.seriaId = seriaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Collection<ParticipantStatistic> getParticipantStatisticsById() {
        return participantStatisticsById;
    }

    public void setParticipantStatisticsById(Collection<ParticipantStatistic> participantStatisticsById) {
        this.participantStatisticsById = participantStatisticsById;
    }
}

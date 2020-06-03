package com.cb.colorbrain.service;

import com.cb.colorbrain.model.Project;
import com.cb.colorbrain.model.ProjectCreator;
import com.cb.colorbrain.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService extends ProjectCreatorService {

    //For All
    public Page<Project> getAllPendingProject(Pageable pageable) {
        return projectRepository.findAllByActiveTrueAndStatus(pageable, 1);
    }

    public Page<Project> getAllOnlineProject(Pageable pageable) {
        return projectRepository.findAllByActiveTrueAndStatus(pageable, 2);
    }

    public Page<Project> getAllFinishedProject(Pageable pageable) {
        return projectRepository.findAllByActiveTrueAndStatus(pageable, 3);
    }
    //For All

    //For Team
    public Page<Project> getAllPendingProject(Pageable pageable, Long teamId) {
        return projectRepository.findAllByActiveTrueAndStatusAndTeamId(pageable, 1, teamId);
    }

    public Page<Project> getAllOnlineProject(Pageable pageable, Long teamId) {
        return projectRepository.findAllByActiveTrueAndStatusAndTeamId(pageable, 2, teamId);
    }

    public Page<Project> getAllFinishedProject(Pageable pageable, Long teamId) {
        return projectRepository.findAllByActiveTrueAndStatusAndTeamId(pageable, 3, teamId);
    }
    //For Team

    public Project getProjectById(Long projectId) {
        return projectRepository.findByActiveTrueAndId(projectId);
    }

    public Page<Project> getAllProjectByUserId(Pageable pageable, Long userId) {
        Page<ProjectCreator> projectCreatorList = projectCreatorRepository.findAllByActiveTrueAndUserId(pageable, userId);
        List<Project> projectList = new ArrayList<>();
        for (ProjectCreator projectCreator : projectCreatorList) {
            projectList.add(projectCreator.getProjectByProjectId());
        }
        return new PageImpl<>(projectList);
    }
}



















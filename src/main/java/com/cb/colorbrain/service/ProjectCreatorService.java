package com.cb.colorbrain.service;

import com.cb.colorbrain.model.Project;
import com.cb.colorbrain.model.ProjectCreator;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.User;
import com.cb.colorbrain.repository.ProjectCreatorRepository;
import com.cb.colorbrain.repository.ProjectRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectCreatorService {

    @Autowired
    public ProjectCreatorRepository projectCreatorRepository;

    @Autowired
    public ProjectRepository projectRepository;

    public List<ProjectCreator> getAllProjectCreatorByProjectId(Long projectId) {
        return projectCreatorRepository.findAllByActiveTrueAndProjectId(projectId);
    }

    public Response addProject(@NotNull Project project, List<User> users, MultipartFile file) {
        try {
            project.setFileNameToObject(FileService.saveSingle(file));
            projectRepository.save(project);
            saveCreatorsOfProject(project, users);
            return new Response("Layihə uğurla yaradıldı", 1);
        } catch (IOException ex) {
            ex.printStackTrace();
            return new Response("Fayl xətası", 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public Response updateProject(@NotNull Project project, List<User> users, int status, String oldImgName) {
        try {
            Project projectFromDb = getProjectFromDB(project, status);
            projectFromDb.setFileNameToObject(oldImgName);
            projectRepository.save(projectFromDb);
            updateCreatorsOfProject(projectFromDb, users);
            return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public Response updateProject(@NotNull Project project, List<User> users, int status, MultipartFile file) {
        try {
            Project projectFromDb = getProjectFromDB(project, status);
            projectFromDb.setFileNameToObject(FileService.saveSingle(file));
            projectRepository.save(projectFromDb);
            updateCreatorsOfProject(projectFromDb, users);
            return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
        } catch (IOException ex) {
            ex.printStackTrace();
            return new Response("Fayl xətası", 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);

        }
    }

    @NotNull
    private Project getProjectFromDB(@NotNull Project project, int status) {
        Project projectFromDb = projectRepository.findByActiveTrueAndId(project.getId());
        projectFromDb.setHeader(project.getHeader());
        projectFromDb.setContext(project.getContext());
        projectFromDb.setDate(project.getDate());
        projectFromDb.setStatus(status);
        return projectFromDb;
    }

    private void saveCreatorsOfProject(Project project, @NotNull List<User> users) {
        for (User user : users) {
            ProjectCreator projectCreator = new ProjectCreator();
            projectCreator.setUserId(user.getId());
            projectCreator.setProjectId(project.getId());
            projectCreatorRepository.save(projectCreator);
        }
    }

    private void updateCreatorsOfProject(@NotNull Project project, @NotNull List<User> users) {
        projectCreatorRepository.deleteByActiveTrueAndProjectId(project.getId());
        saveCreatorsOfProject(project, users);
    }

}
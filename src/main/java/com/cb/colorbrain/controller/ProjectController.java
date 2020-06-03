package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Project;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.User;
import com.cb.colorbrain.service.ProjectService;
import com.cb.colorbrain.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @GetMapping("project/online")
    public String getAllOnlineProject(
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", projectService.getAllOnlineProject(pageable));
        model.addAttribute("url", "/project/online");
        return "project";
    }

    @GetMapping("project/finished")
    public String getAllFinishedProject(
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", projectService.getAllFinishedProject(pageable));
        model.addAttribute("url", "/project/finished");
        return "project";
    }

    @GetMapping("project/pending")
    public String getAllPendingProject(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", projectService.getAllPendingProject(pageable));
        model.addAttribute("url", "/project/pending");
        redirectAttributes.addFlashAttribute("response", response);
        return "project";
    }

    @GetMapping("team/{teamId}/project/online")
    public String getAllOnlineProjectByTeamId(
            @PathVariable Long teamId,
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("userTeamId", teamId);
        model.addAttribute("page", projectService.getAllOnlineProject(pageable, teamId));
        model.addAttribute("url", "/team/" + teamId + "/projcet/online");
        return "teamAllProject";
    }

    @GetMapping("team/{teamId}/project/pending")
    public String getAllPendingProjectByTeamId(
            @PathVariable Long teamId,
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", projectService.getAllPendingProject(pageable, teamId));
        model.addAttribute("userTeamId", teamId);
        model.addAttribute("url", "/team/" + teamId + "/projcet/pending");
        return "teamAllProject";
    }

    @GetMapping("team/{teamId}/project/finished")
    public String getAllFinishedProjectByTeamId(
            @PathVariable Long teamId,
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("userTeamId", teamId);
        model.addAttribute("page", projectService.getAllFinishedProject(pageable, teamId));
        model.addAttribute("url", "/team/" + teamId + "/projcet/finished");
        return "teamAllProject";
    }


    ////////////////////////////////////////////////////


    @GetMapping("/team/{teamId}/user/{userId}/project")
    public String getAllProjectByUserId(
            @PathVariable("teamId") Long teamId,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull @PathVariable("userId") User user,
            @NotNull Model model
    ) {
        model.addAttribute("page", projectService.getAllProjectByUserId(pageable, user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("url", "/team/" + teamId + "/user/" + user.getId() + "/projcet");
        return "UserAllProject";
    }

    @GetMapping("/team/{teamId}/project/add")
    public String getTeamAddProperties(
            @PathVariable Long teamId,
            @NotNull Model model
    ) {
        model.addAttribute("users", userService.getUsersByTeamId(teamId));
        return "projectAdd";
    }


    @PostMapping("/team/{teamId}/project/add")
    public String addProject(
            @PathVariable Long teamId,
            @RequestParam("users") List<User> users,
            @RequestParam("header") String header,
            @RequestParam("context") String context,
            @RequestParam("date") String date,
            @RequestParam("imgName") MultipartFile file,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = projectService.addProject(new Project(teamId, header, context, LocalDateTime.parse(date)), users, file);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/project/pending/";
    }

    @PostMapping("/team/{teamId}/project/{projectId}/update/")
    public String updateProject(
            @PathVariable Long teamId,
            @PathVariable Long projectId,
            @RequestParam("users") List<User> users,
            @RequestParam("header") String header,
            @RequestParam("context") String context,
            @RequestParam("date") String date,
            @RequestParam("status") int status,
            @RequestParam("oldImg") String oldImgName,
            @NotNull @RequestParam("imgName") MultipartFile file,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = null;
        Project project = new Project(projectId, teamId, header, context, LocalDateTime.parse(date));
        if (file.getOriginalFilename().isEmpty()) {
            response = projectService.updateProject(project, users, status, oldImgName);
        } else {
            response = projectService.updateProject(project, users, status, file);
        }
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/project/pending/";
    }

    @GetMapping("/team/{teamId}/project/{projectId}/info/")
    public String getProjectInfo(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable Long teamId,
            @PathVariable Long projectId,
            @NotNull Model model
    ) {
        model.addAttribute("projectUsers", userService.getUsersByProjectId(projectId));
        model.addAttribute("otherUsers", userService.getUsersByTeamId(teamId));
        model.addAttribute("project", projectService.getProjectById(projectId));
        redirectAttributes.addFlashAttribute("response", response);
        return "projectInfo";
    }


    @GetMapping("/team/{teamId}/project/{projectId}/update/")
    public String getUpdateProperties(
            @PathVariable Long teamId,
            @PathVariable Long projectId,
            @NotNull Model model
    ) {
        model.addAttribute("projectUsers", userService.getUsersByProjectId(projectId));
        model.addAttribute("otherUsers", userService.getUsersByTeamId(teamId));
        model.addAttribute("project", projectService.getProjectById(projectId));
        return "projectUpdate";
    }
}

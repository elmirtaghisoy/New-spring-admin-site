package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.Team;
import com.cb.colorbrain.service.TeamService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TeamController {

    @Autowired
    protected TeamService teamService;

    @GetMapping("/team")
    public String getUserList(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @NotNull Model model
    ) {
        model.addAttribute("team", teamService.getAllTeamWithInfo());
        redirectAttributes.addFlashAttribute("response", response);
        return "team";
    }

    @PostMapping("team/addTeam")
    public String addTeam(
            Team team,
            @RequestParam("file") MultipartFile file,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = teamService.addTeam(team, file);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team";
    }

    @GetMapping("team/{teamId}")
    public String getTeamInfo(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable("teamId") Long teamId,
            @NotNull Model model
    ) {
        model.addAttribute("team", teamService.getTeamById(teamId));
        model.addAttribute("selectedTeamId", teamId);
        redirectAttributes.addFlashAttribute("response", response);
        return "teamInfo";
    }

    @PostMapping("/team/{teamId}/updateTeam")
    public String updateTeam(
            @PathVariable("teamId") Long teamId,
            @RequestParam("teamName") String teamName,
            @RequestParam("teamDesc") String teamDesc,
            @RequestParam("oldImgName") String oldImgName,
            @NotNull @RequestParam("file") MultipartFile file,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = null;
        Team team = new Team(teamName, teamDesc);
        if (file.getOriginalFilename().isEmpty()) {
            team.setImgName(oldImgName);
            response = teamService.updateTeam(team, teamId, oldImgName);
        } else {
            response = teamService.updateTeam(team, teamId, file);
        }
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId;
    }
}

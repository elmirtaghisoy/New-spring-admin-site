package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.Role;
import com.cb.colorbrain.model.User;
import com.cb.colorbrain.service.TeamService;
import com.cb.colorbrain.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    protected UserService userService;

    @Autowired
    private TeamService teamService;

    @PostMapping("user/profile")
    public String updateProfile(
            User user,
            @RequestParam String password,
            @RequestParam String email
    ) {
        userService.updateProfile(user, password, email);
        return "redirect:/user/profile";
    }

    @GetMapping("/users")
    public String getAllUser(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", userService.getAllUser(pageable));
        model.addAttribute("url", "/users");
        return "allMember";
    }

    @GetMapping("/team/{teamId}/users")
    public String getUsersByTeamId(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable("teamId") Long teamId,
            @NotNull Model model
    ) {
        model.addAttribute("page", userService.getUsersByTeamId(pageable, teamId));
        model.addAttribute("url", "/team/" + teamId + "/users");
        redirectAttributes.addFlashAttribute("response", response);
        return "teamAllMember";
    }

    @GetMapping("/team/{teamId}/{getType}/user/{userId}")
    public String getUserById(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable("userId") Long userId,
            @PathVariable("teamId") Long teamId,
            @NotNull @PathVariable("getType") String getType,
            @NotNull Model model
    ) {
        String page = null;
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("team", teamService.getTeamById(teamId));
        if (getType.equals("update")) {
            model.addAttribute("roles", Role.values());
            model.addAttribute("otherTeams", teamService.getAllTeam());
            page = "teamMemberUpdate";
        } else if (getType.equals("info")) {
            page = "UserInfo";
        }
        return page;
    }


    @PostMapping("/user/update")
    public String updateUser(
            @NotNull @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam Map<String, String> form,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = null;
        if (file.getOriginalFilename().isEmpty()) {
            response = userService.updateUserById(form);
        } else {
            response = userService.updateUserById(form, file);
        }
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + Long.parseLong(form.get("teamId")) + "/update/user/" + Long.parseLong(form.get("userId"));
    }

    @PostMapping("/team/{teamId}/deactive/user/{userId}")
    public String deactivateUser(
            @PathVariable(value = "teamId") Long teamId,
            @PathVariable("userId") Long userId,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = userService.deactivateUser(userId);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/users";
    }

    @PostMapping("/team/{teamId}/activate/user/{userId}")
    public String activateUser(
            @PathVariable(value = "teamId") Long teamId,
            @PathVariable("userId") Long userId,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = userService.activate(userId);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/users";
    }

}
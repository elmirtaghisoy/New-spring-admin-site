package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Applicant;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.service.ApplicantService;
import com.cb.colorbrain.service.TeamService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private TeamService teamService;

//    @GetMapping("/applicants")
//    public String getApplicants(
//            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
//            @NotNull Model model
//    ) {
//        model.addAttribute("applicantList", applicantService.getAllApplicant(pageable));
//        return "teamAllApplicant";
//    }

    @GetMapping("team/{teamId}/applicants/")
    public String getApplicantsByTeamId(
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
            @PathVariable("teamId") Long teamId,
            @NotNull Model model
    ) {
        model.addAttribute("page", applicantService.getAllApplicant(pageable, teamId));
        model.addAttribute("url", "team/" + teamId + "/applicants/");
        return "teamAllApplicant";
    }


    @GetMapping("colorbrain/applicant/")
    public String getApplyProperties(
            @NotNull Model model
    ) {
        model.addAttribute("teamList", teamService.getAllTeam());
        return "clientPage";
    }

    @GetMapping("/team/{teamId}/applicant/{applicantId}")
    public String getApplicantById(
            @PathVariable("teamId") Long teamId,
            @PathVariable("applicantId") Long applicantId,
            @NotNull Model model
    ) {
        model.addAttribute("applicant", applicantService.getApplicantById(applicantId));
        model.addAttribute("teamList", teamService.getAllTeam());
        return "teamActivateApplicant";
    }

    @PostMapping("/colorbrain/applicant/apply")
    public String sendRequest(
            @RequestParam Map<String, String> form
    ) {
        applicantService.addApplicant(form);
        return "redirect:/main";
    }
}

package com.cb.colorbrain.service;

import com.cb.colorbrain.model.Applicant;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.repository.ApplicantRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public Page<Applicant> getAllApplicant(Pageable pageable, Long teamId) {
        return applicantRepository.findAllByActiveTrueAndTeamId(pageable, teamId);
    }

    public Page<Applicant> getAllApplicant(Pageable pageable) {
        return applicantRepository.findAllByActiveTrue(pageable);
    }

    public Applicant getApplicantById(Long applicantId) {
        return applicantRepository.findByActiveTrueAndId(applicantId);
    }

    public void addApplicant(Map<String, String> form) {
        Applicant applicant = new Applicant();
        applicant.setDate(LocalDateTime.now());
        setDataToObject(applicant, form);
        applicantRepository.save(applicant);
    }

    private void setDataToObject(@NotNull Applicant applicant, @NotNull Map<String, String> form) {
        applicant.setName(form.get("name"));
        applicant.setSurname(form.get("surname"));
        applicant.setPhone(form.get("phone"));
        applicant.setEmail(form.get("email"));
        applicant.setBrithday(LocalDate.parse(form.get("brithday")));
        applicant.setBrithdayPlace(form.get("birthdayPlace"));
        applicant.setCurrentAddress(form.get("currentAddress"));
        applicant.setTeamId(Long.parseLong(form.get("teamId")));
        applicant.setHobbySkill(form.get("hobbySkill"));
        applicant.setWhyUs(form.get("whyUs"));
        applicant.setSocialActivitiy(form.get("whereFindUs"));
        applicant.setAdditionalIdeas(form.get("additionalIdeas"));
        applicant.setEduInfo(form.get("eduInfo"));
        applicant.setInstagram(form.get("instagram"));
        applicant.setFacebook(form.get("facebook"));
        applicant.setLinkedin(form.get("linkedin"));
        applicant.setTwitter(form.get("twitter"));
    }
}

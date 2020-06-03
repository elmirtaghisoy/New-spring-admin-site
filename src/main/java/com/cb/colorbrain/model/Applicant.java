package com.cb.colorbrain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String currentAddress;
    @Column(name = "team_id")
    private Long teamId;
    private LocalDateTime date;
    private LocalDate brithday;
    private String brithdayPlace;
    private String hobbySkill;
    private String socialActivitiy;
    private String whyUs;
    private String whereFindUs;
    private String additionalIdeas;
    private String eduInfo;
    private int status;
    private boolean active = true;
    private String activationCode;
    private String instagram;
    private String facebook;
    private String twitter;
    private String linkedin;

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;

    public Applicant() {

    }

    public Applicant(
            String name, String surname,
            String brithdayPlace, LocalDate brithday,
            String phone, String email,
            String currentAddress, Long teamId,
            String hobbySkill, String whyUs,
            String socialActivitiy, String whereFindUs,
            String additionalIdeas, String eduInfo,
            String instagram, String facebook,
            String linkedin, String twitter
    ) {
        this.name = name;
        this.surname = surname;
        this.brithdayPlace = brithdayPlace;
        this.brithday = brithday;
        this.phone = phone;
        this.email = email;
        this.currentAddress = currentAddress;
        this.teamId = teamId;
        this.hobbySkill = hobbySkill;
        this.whyUs = whyUs;
        this.socialActivitiy = socialActivitiy;
        this.whereFindUs = whereFindUs;
        this.additionalIdeas = additionalIdeas;
        this.eduInfo = eduInfo;
        this.instagram = instagram;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.twitter = twitter;
    }


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getHobbySkill() {
        return hobbySkill;
    }

    public void setHobbySkill(String hobbySkill) {
        this.hobbySkill = hobbySkill;
    }

    public String getSocialActivitiy() {
        return socialActivitiy;
    }

    public void setSocialActivitiy(String socialActivitiy) {
        this.socialActivitiy = socialActivitiy;
    }

    public String getWhyUs() {
        return whyUs;
    }

    public void setWhyUs(String whyUs) {
        this.whyUs = whyUs;
    }

    public String getWhereFindUs() {
        return whereFindUs;
    }

    public void setWhereFindUs(String whereFindUs) {
        this.whereFindUs = whereFindUs;
    }

    public String getAdditionalIdeas() {
        return additionalIdeas;
    }

    public void setAdditionalIdeas(String additionalIdeas) {
        this.additionalIdeas = additionalIdeas;
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDate getBrithday() {
        return brithday;
    }

    public void setBrithday(LocalDate brithday) {
        this.brithday = brithday;
    }

    public String getBrithdayPlace() {
        return brithdayPlace;
    }

    public void setBrithdayPlace(String brithdayPlace) {
        this.brithdayPlace = brithdayPlace;
    }

    public String getEduInfo() {
        return eduInfo;
    }

    public void setEduInfo(String eduInfo) {
        this.eduInfo = eduInfo;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Applicant{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", currentAddress='").append(currentAddress).append('\'');
        sb.append(", teamId=").append(teamId);
        sb.append(", date=").append(date);
        sb.append(", brithday=").append(brithday);
        sb.append(", brithdayPlace='").append(brithdayPlace).append('\'');
        sb.append(", hobbySkill='").append(hobbySkill).append('\'');
        sb.append(", socialActivitiy='").append(socialActivitiy).append('\'');
        sb.append(", whyUs='").append(whyUs).append('\'');
        sb.append(", whereFindUs='").append(whereFindUs).append('\'');
        sb.append(", additionalIdeas='").append(additionalIdeas).append('\'');
        sb.append(", eduInfo='").append(eduInfo).append('\'');
        sb.append(", status=").append(status);
        sb.append(", active=").append(active);
        sb.append(", activationCode='").append(activationCode).append('\'');
        sb.append(", instagram='").append(instagram).append('\'');
        sb.append(", facebook='").append(facebook).append('\'');
        sb.append(", twitter='").append(twitter).append('\'');
        sb.append(", linkedin='").append(linkedin).append('\'');
        sb.append(", team=").append(team);
        sb.append('}');
        return sb.toString();
    }
}

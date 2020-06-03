package com.cb.colorbrain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Username can't be empty")
    private String username;
    @NotBlank(message = "Password can't be empty")
    private String password;

    private boolean active;
    @Email(message = "Email isn't correct")
    @NotBlank(message = "Email can't be empty")
    private String email;
    private String activationCode;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    ///////////////////////////////////////////////////////////////////////////
//                     UserDetails Methods Start                         //
///////////////////////////////////////////////////////////////////////////
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    ///////////////////////////////////////////////////////////////////////////
//                      UserDetails Methods End                          //
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
//                        Other Methods Start                            //
///////////////////////////////////////////////////////////////////////////
    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }
///////////////////////////////////////////////////////////////////////////
//                        Other Methods End                              //
///////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////
//                        Custom Methods and Fields                     //
//                             We already use                           //
//              id, username,password,active,activation_code,email      //
//////////////////////////////////////////////////////////////////////////

    private String name;
    private String surname;
    private String phone;
    private String seriaId;
    private Date brithday;
    private String brithdayPlace;
    private String currentAddress;
    private String hobbySkill;
    private String socialActivitiy;
    private String otherCompany;
    private String whyUs;
    private String whereFindUs;
    private String additionalIdeas;
    private String userImg;
    @Column(name = "team_id")
    private Integer teamId;

    @OneToMany(targetEntity = ProjectCreator.class, mappedBy = "userId")
    private Collection<ProjectCreator> projectCreatorsById;

    @OneToMany(targetEntity = EducationInfo.class, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<EducationInfo> educationInfoById;

    @OneToMany(targetEntity = LangSkill.class, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<LangSkill> langSkillsById;

    @OneToMany(targetEntity = Post.class, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<Post> postsById;

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

    public String getSeriaId() {
        return seriaId;
    }

    public void setSeriaId(String seriaId) {
        this.seriaId = seriaId;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getBrithdayPlace() {
        return brithdayPlace;
    }

    public void setBrithdayPlace(String brithdayPlace) {
        this.brithdayPlace = brithdayPlace;
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

    public String getOtherCompany() {
        return otherCompany;
    }

    public void setOtherCompany(String otherCompany) {
        this.otherCompany = otherCompany;
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

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Collection<EducationInfo> getEducationInfoById() {
        return educationInfoById;
    }

    public void setEducationInfoById(Collection<EducationInfo> educationInfoById) {
        this.educationInfoById = educationInfoById;
    }

    public Collection<LangSkill> getLangSkillsById() {
        return langSkillsById;
    }

    public void setLangSkillsById(Collection<LangSkill> langSkillsById) {
        this.langSkillsById = langSkillsById;
    }

    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }

    public Collection<ProjectCreator> getProjectCreatorsById() {
        return projectCreatorsById;
    }

    public void setProjectCreatorsById(Collection<ProjectCreator> projectCreatorsById) {
        this.projectCreatorsById = projectCreatorsById;
    }
}

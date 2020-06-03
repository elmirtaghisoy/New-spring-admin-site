package com.cb.colorbrain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Collection;
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

    public User() {
    }

    public User(
            String name, String surname,
            LocalDate brithday, String brithdayPlace,
            String phone, String email,
            Long teamId, String currentAddress,
            String socialActivitiy, String additionalIdeas,
            String hobbySkill, String whereFindUs,
            String whyUs, String eduInfo,
            String instagram, String facebook,
            String linkedin, String twitter
    ) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.brithday = brithday;
        this.brithdayPlace = brithdayPlace;
        this.currentAddress = currentAddress;
        this.hobbySkill = hobbySkill;
        this.socialActivitiy = socialActivitiy;
        this.whyUs = whyUs;
        this.whereFindUs = whereFindUs;
        this.additionalIdeas = additionalIdeas;
        this.eduInfo = eduInfo;
        this.teamId = teamId;
        this.instagram = instagram;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.twitter = twitter;
    }

    public User(
            Long userId, String name,
            String surname, String brithdayPlace,
            LocalDate brithday, String phone,
            String email, String currentAddress,
            Long teamId, String hobbySkill,
            String whyUs, String socialActivitiy,
            String whereFindUs, String additionalIdeas,
            String eduInfo, String instagram,
            String facebook, String linkedin,
            String twitter
    ) {
        this.id = userId;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.brithday = brithday;
        this.brithdayPlace = brithdayPlace;
        this.currentAddress = currentAddress;
        this.hobbySkill = hobbySkill;
        this.socialActivitiy = socialActivitiy;
        this.whyUs = whyUs;
        this.whereFindUs = whereFindUs;
        this.additionalIdeas = additionalIdeas;
        this.eduInfo = eduInfo;
        this.teamId = teamId;
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

    public boolean isUser() {
        return roles.contains(Role.USER);
    }

    public boolean isLeader() {
        return roles.contains(Role.LEADER);
    }

    public Long getAdminId() {
        return id;
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
    private LocalDate brithday;
    private String brithdayPlace;
    private String currentAddress;
    private String hobbySkill;
    private String socialActivitiy;
    private String whyUs;
    private String whereFindUs;
    private String additionalIdeas;
    private String eduInfo;
    private String userImg;
    @Column(name = "team_id")
    private Long teamId;
    private String instagram;
    private String facebook;
    private String twitter;
    private String linkedin;

    @OneToMany(targetEntity = ProjectCreator.class, mappedBy = "userId")
    private Collection<ProjectCreator> projectCreatorsById;

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

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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

    public String getEduInfo() {
        return eduInfo;
    }

    public void setEduInfo(String eduInfo) {
        this.eduInfo = eduInfo;
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
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", active=").append(active);
        sb.append(", email='").append(email).append('\'');
        sb.append(", activationCode='").append(activationCode).append('\'');
        sb.append(", roles=").append(roles);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", brithday=").append(brithday);
        sb.append(", brithdayPlace='").append(brithdayPlace).append('\'');
        sb.append(", currentAddress='").append(currentAddress).append('\'');
        sb.append(", hobbySkill='").append(hobbySkill).append('\'');
        sb.append(", socialActivitiy='").append(socialActivitiy).append('\'');
        sb.append(", whyUs='").append(whyUs).append('\'');
        sb.append(", whereFindUs='").append(whereFindUs).append('\'');
        sb.append(", additionalIdeas='").append(additionalIdeas).append('\'');
        sb.append(", eduInfo='").append(eduInfo).append('\'');
        sb.append(", userImg='").append(userImg).append('\'');
        sb.append(", teamId=").append(teamId);
        sb.append(", instagram='").append(instagram).append('\'');
        sb.append(", facebook='").append(facebook).append('\'');
        sb.append(", twitter='").append(twitter).append('\'');
        sb.append(", linkedin='").append(linkedin).append('\'');
        sb.append(", projectCreatorsById=").append(projectCreatorsById);
        sb.append(", postsById=").append(postsById);
        sb.append('}');
        return sb.toString();
    }
}

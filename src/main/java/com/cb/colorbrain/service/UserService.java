package com.cb.colorbrain.service;

import com.cb.colorbrain.model.*;
import com.cb.colorbrain.repository.ApplicantRepository;
import com.cb.colorbrain.repository.UserRepoository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService extends ProjectCreatorService implements UserDetailsService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private UserRepoository userRepoository;

    @Autowired
    private MailSendService mailSendService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepoository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }

    public boolean addUser(@NotNull User user, Applicant applicant) {
        if (userRepoository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        User newUser = new User(
                applicant.getName(),
                applicant.getSurname(),
                applicant.getBrithday(),
                applicant.getBrithdayPlace(),
                applicant.getPhone(),
                applicant.getEmail(),
                applicant.getTeamId(),
                applicant.getCurrentAddress(),
                applicant.getSocialActivitiy(),
                applicant.getAdditionalIdeas(),
                applicant.getHobbySkill(),
                applicant.getWhereFindUs(),
                applicant.getWhyUs(),
                applicant.getEduInfo(),
                applicant.getInstagram(),
                applicant.getFacebook(),
                applicant.getLinkedin(),
                applicant.getTwitter()
        );
        newUser.setUsername(user.getUsername());
        newUser.setRoles(Collections.singleton(Role.USER));
        newUser.setActivationCode(UUID.randomUUID().toString());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepoository.save(newUser);
        sendMessage(newUser);
        applicant.setStatus(0);
        applicantRepository.save(applicant);
        return true;
    }

    private void sendMessage(@NotNull User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to 'MY APP'. Please, visit next link: http://localhost:8081/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSendService.send(user.getEmail(), "Activation code", message);
        }
    }

    public boolean activateUser(String code) {
        User user = userRepoository.findByActivationCode(code);
        if (user == null)
            return false;
        user.setActive(true);
        user.setActivationCode(null);
        userRepoository.save(user);
        return true;
    }

    public void updateProfile(@NotNull User user, String password, String email) {
        String userEmail = user.getEmail();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged) {
            user.setEmail(email);

            if (!StringUtils.isEmpty(email)) {
                user.setActivationCode(UUID.randomUUID().toString());
            }
        }

        if (!StringUtils.isEmpty(password)) {
            user.setPassword(passwordEncoder.encode(password));
        }

        userRepoository.save(user);

        if (isEmailChanged) {
            sendMessage(user);
        }
    }

    public List<User> getUsersByTeamId(Long teamId) {
        return userRepoository.findAllByTeamId(teamId);
    }

    public Page<User> getUsersByTeamId(Pageable pageable, Long teamId) {
        return userRepoository.findAllByTeamId(pageable, teamId);
    }

    public List<User> getUsersByProjectId(Long projectId) {
        List<ProjectCreator> projectCreators = getAllProjectCreatorByProjectId(projectId);
        List<User> users = new ArrayList<>();
        for (ProjectCreator projectCreator : projectCreators) {
            users.add(projectCreator.getUserByUserId());
        }
        return users;
    }

    private boolean sendRegPage(@NotNull Applicant applicant) {
        if (!StringUtils.isEmpty(applicant.getEmail())) {
            String message = String.format(
                    "Salam, %s %s ! \n" +
                            "Siz ColorBrain komandasına qoşuldunuz, Bu linkə daxil olub qeydiyyatdan keçərək qeydiyyatınızı tamamlayın " +
                            ": http://localhost:8081/regP/%d/%s",
                    applicant.getName(),
                    applicant.getSurname(),
                    applicant.getId(),
                    applicant.getActivationCode()
            );
            mailSendService.send(applicant.getEmail(), "Registration", message);
            return true;
        }
        return false;
    }

    @NotNull
    private Applicant activateApplicant(Long applicantId) {
        Applicant applicant = applicantRepository.getOne(applicantId);
        applicant.setActivationCode(UUID.randomUUID().toString());
        applicant.setStatus(2);
        return applicant;
    }

    public boolean checkApplicantActivation(String token) {
        Applicant applicant = applicantRepository.findByActivationCode(token);
        if (applicant == null)
            return false;
        applicant.setActivationCode(null);
        applicantRepository.save(applicant);
        return true;
    }

    public boolean checkUserActivationCode(String token) {
        User user = userRepoository.findByActivationCode(token);
        if (user == null)
            return false;
        user.setActivationCode(null);
        userRepoository.save(user);
        return true;
    }

    public Response activationApplicant(Long applicantId) {
        Response response = null;
        try {
            if (sendRegPage(activateApplicant(applicantId))) {
                response = new Response("Akitvasiya kodu istifadəçiyə göndərildi", 1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response = new Response("Xəta", 0);
        }
        return response;
    }

    public User getUserById(Long userId) {
        return userRepoository.getOne(userId);
    }

    public Response updateUserById(@NotNull Map<String, String> form, MultipartFile file) {
        try {
            if (!form.isEmpty()) {
                User user = userRepoository.getOne(Long.parseLong(form.get("userId")));
                if (user != null) {
                    if (setFormDataToObject(user, form)) {
                        user.setUserImg(FileService.saveSingle(file));
                        return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
                    } else {
                        return new Response("Dəyişiklik zamanı xəta baş verdi", 0);
                    }
                } else {
                    return new Response("İstifadəçi tapılmadı", 0);
                }
            } else {
                return new Response("Məlumatlar daxil edilməyib", 0);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return new Response("Faylda xəta", 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public Response updateUserById(@NotNull Map<String, String> form) {
        if (!form.isEmpty()) {
            User user = userRepoository.getOne(Long.parseLong(form.get("userId")));
            if (user != null) {
                if (setFormDataToObject(user, form)) {
                    user.setUserImg(form.get("oldImgName"));
                    return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
                } else {
                    return new Response("Dəyişiklik zamanı xəta baş verdi", 0);
                }
            } else {
                return new Response("İstifadəçi tapılmadı", 0);
            }
        } else {
            return new Response("Məlumatlar daxil edilməyib", 0);
        }
    }

    public Response deactivateUser(Long userId) {
        try {
            User user = userRepoository.getOne(userId);
            user.setActive(false);
            userRepoository.save(user);
            return new Response("İstifadəçi deaktiv edildi", 1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public Response activate(Long userId) {
        try {
            User user = userRepoository.getOne(userId);
            user.setActive(true);
            userRepoository.save(user);
            return new Response("İstifadəçi aktiv edildi", 1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    private void setUserRole(@NotNull Map<String, String> form, @NotNull User user) {
        user.getRoles().clear();
        Set<String> roles = Arrays
                .stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
    }

    private boolean setFormDataToObject(User user, Map<String, String> form) {
        setUserRole(form, user);
        user.setName(form.get("name"));
        user.setSurname(form.get("surname"));
        user.setPhone(form.get("phone"));
        user.setEmail(form.get("email"));
        user.setBrithday(LocalDate.parse(form.get("brithday")));
        user.setBrithdayPlace(form.get("birthdayPlace"));
        user.setCurrentAddress(form.get("currentAddress"));
        user.setTeamId(Long.parseLong(form.get("teamId")));
        user.setHobbySkill(form.get("hobbySkill"));
        user.setWhyUs(form.get("whyUs"));
        user.setSocialActivitiy(form.get("whereFindUs"));
        user.setAdditionalIdeas(form.get("additionalIdeas"));
        user.setEduInfo(form.get("eduInfo"));
        user.setUserImg(form.get("oldImgName"));
        user.setInstagram(form.get("instagram"));
        user.setFacebook(form.get("facebook"));
        user.setLinkedin(form.get("linkedin"));
        user.setTwitter(form.get("twitter"));
        return true;
    }

    public Page<User> getAllUser(Pageable pageable) {
        return userRepoository.findAllByActiveTrue(pageable);
    }

    public Response sendActivationCode(@NotNull User user) {
        try {
            User userFromDb = userRepoository.getOne(user.getId());
            userFromDb.setActivationCode(UUID.randomUUID().toString());
            if (!sendUpdatePage(userFromDb)) {
                return new Response("Xəta", 0);
            }
            return new Response("Aktivasiya kodu istifadəçiyə göndərildi", 1);
        } catch (Exception ex) {
            return new Response("Xəta", 0);
        }
    }

    private boolean sendUpdatePage(@NotNull User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Salam, %s %s ! \n" +
                            "Şifrənizi yeniləmək üçün linkə daxil olub yeni şifrənizi daxil edin:" +
                            ": http://localhost:8081/updP/%d/%s",
                    user.getName(),
                    user.getSurname(),
                    user.getId(),
                    user.getActivationCode()
            );
            mailSendService.send(user.getEmail(), "Update Password", message);
            return true;
        }
        return false;
    }

    public Response updateUserCredentials(@NotNull User user) {
        User newUser = userRepoository.findByUsername(user.getUsername());
        if (null != newUser) {
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepoository.save(newUser);
            return new Response("Şifrəniz yeniləndi... Sistemə yenidən daxil ola bilərsiniz", 1);
        } else {
            return new Response("Xəta", 0);
        }
    }

}

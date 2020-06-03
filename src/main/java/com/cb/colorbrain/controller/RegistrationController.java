package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Applicant;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.User;
import com.cb.colorbrain.model.dto.CaptchaResponseDto;
import com.cb.colorbrain.service.UserService;
import com.cb.colorbrain.utils.ControllerUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Value("${recaptcha.secret}")
    private String secret;

    //update user

    @GetMapping("/users/user/{userId}/profile")
    public String getProfile(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @NotNull @PathVariable("userId") User user,
            @NotNull Model model
    ) {
        model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("response", response);
        return "profile";
    }

    @PostMapping("/users/user/{userId}/profile")
    public String sendRefreshPasswordPage(
            @NotNull @PathVariable("userId") User user,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = userService.sendActivationCode(user);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/users/user/" + user.getId() + "/profile";
    }

    @GetMapping("updP/{userId}/{token}")
    public String getUpdatePage(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable("userId") User user,
            @PathVariable("token") String token,
            Model model
    ) {
        boolean isActivated = userService.checkUserActivationCode(token);
        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Yeni şifrəni daxil edin");
            model.addAttribute("user", user);
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Xəta");
        }
        redirectAttributes.addFlashAttribute("response", response);
        return "updateCredentials";
    }

    @PostMapping("/updateUserCredentials")
    public String updateUserCredentials(
            @RequestParam("passwordConfirm") String passwordConfirm,
            @RequestParam("g-recaptcha-response") String captchaResponse,
            @NotNull User user,
            Model model,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);


        if (!response.isSuccess()) {
            model.addAttribute("captchaError", "Fill captcha");
        }

        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);

        if (isConfirmEmpty) {
            model.addAttribute("password2Error", "Şifrəni təsdiq edin.");
        }

        if (user.getPassword() != null && !user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Daxil etdiyiniz şifrələr fərqlidir.");
        }

        Response resp = userService.updateUserCredentials(user);
        redirectAttributes.addFlashAttribute("response", resp);
        // captcha errora baxmir
        // parolu yoxlamir
        return "redirect:/login";
    }


    //create user
    @PostMapping("/sendRegPage")
    public String sendRegPage(
            @RequestParam("applicantId") Long applicantId,
            @RequestParam("teamId") Long teamId,
            Model model,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = userService.activationApplicant(applicantId);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/applicant/" + applicantId;
    }


    @GetMapping("regP/{applicantId}/{token}")
    public String registration(
            @PathVariable("applicantId") Long applicantId,
            @PathVariable("token") String token,
            Model model
    ) {
        boolean isActivated = userService.checkApplicantActivation(token);
        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Aktivasiya prosesini tamamlamaq üçün qeydiyyatdan keçin.");
            model.addAttribute("applicantId", applicantId);
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Xəta");
        }
        return "registration";
    }


    @PostMapping("/regP/registration")
    public String addUser(
            @RequestParam("passwordConfirm") String passwordConfirm,
            @RequestParam("g-recaptcha-response") String captchaResponse,
            @RequestParam("applicantId") Applicant applicant,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ) {
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);

        if (!response.isSuccess()) {
            model.addAttribute("captchaError", "Fill captcha");
        }

        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);

        if (isConfirmEmpty) {
            model.addAttribute("password2Error", "Şifrəni təsdiq edin.");
        }

        if (user.getPassword() != null && !user.getPassword().equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Daxil etdiyiniz şifrələr fərqlidir.");
        }

        if (isConfirmEmpty || bindingResult.hasErrors() || !response.isSuccess()) {
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registration";
        }

        if (!userService.addUser(user, applicant)) {
            model.addAttribute("usernameError", "İstifadəçi adı mövcuddur.");
            return "registration";
        }

        //error cixanda ne olmalidir.
        //burda clientin esas sehifesine gonder.
        return "registration";
    }

    @GetMapping("/activate/{code}")
    public String activate(
            Model model,
            @PathVariable String code
    ) {
        if (userService.activateUser(code)) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "Aktivasiya prosesi uğurla yerinə yetirildi.");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Aktivasiya prosesində xəta baş verdi.");
        }
        return "login";
    }
}

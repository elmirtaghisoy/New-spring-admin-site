package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Post;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.User;
import com.cb.colorbrain.service.CategorieService;
import com.cb.colorbrain.service.PostService;
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

import java.io.IOException;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public String getAllPost(
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", postService.getAllPost(pageable));
        model.addAttribute("url", "/post");
        return "post";
    }


    @GetMapping("/team/{teamId}/post/{postId}/info")
    public String getPostById(
            @PathVariable Long postId,
            @PathVariable Long teamId,
            @NotNull Model model
    ) {
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        model.addAttribute("fileList", post.getFilesById());
        return "postInfo";
    }

    @GetMapping("/team/{teamId}/post")
    public String getAllPostByTeamId(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable Long teamId,
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", postService.getAllPostByTeamId(pageable, teamId));
        model.addAttribute("url", "/team/" + teamId + "/post");
        redirectAttributes.addFlashAttribute("response", response);
        return "teamAllPost";
    }

    @GetMapping("/team/{teamId}/user/{userId}/post")
    public String getAllPostByUserId(
            @PathVariable("teamId") Long teamId,
            @NotNull @PathVariable("userId") User user,
            @PageableDefault(sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable,
            @NotNull Model model
    ) {
        model.addAttribute("page", postService.getPostByUserId(pageable, user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("url", "/team/" + teamId + "/user/" + user.getId() + "/post");
        return "UserAllPost";
    }

    @GetMapping("/team/{teamId}/post/add")
    public String getAddPropertiesByTeam(
            @PathVariable Long teamId,
            @NotNull Model model
    ) {
        model.addAttribute("users", userService.getUsersByTeamId(teamId));
        model.addAttribute("categories", categorieService.getAllCategorie());
        return "postAdd";
    }


    @PostMapping("/team/{teamId}/post/add")
    public String addPost(
            Post post,
            @PathVariable Long teamId,
            @NotNull @RequestParam("files") List<MultipartFile> files,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = postService.addPost(teamId, post, files);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/post";
    }


    @PostMapping("/team/{teamId}/post/{postId}/update")
    public String updatePost(
            @PathVariable Long teamId,
            @PathVariable("postId") Post post,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = postService.updatePost(post);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/team/" + teamId + "/post/" + post.getId() + "/update";
    }

    @GetMapping("/team/{teamId}/post/{postId}/update")
    public String getUpdateProperties(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable Long teamId,
            @PathVariable Long postId,
            @NotNull Model model
    ) {
        model.addAttribute("post", postService.getPostById(postId));
        model.addAttribute("users", userService.getUsersByTeamId(teamId));
        model.addAttribute("categories", categorieService.getAllCategorie());
        redirectAttributes.addFlashAttribute("response", response);
        return "postUpdate";
    }
}

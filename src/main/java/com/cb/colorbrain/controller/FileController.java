package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Post;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.service.FileService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/files/update/{postId}")
    public String getAllPostFile(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable("postId") Post post,
            Model model
    ) {
        model.addAttribute("fileList", fileService.getAllFileByPostId(post.getId()));
        model.addAttribute("postId", post.getId());
        model.addAttribute("teamId", post.getTeamId());
        return "filesUpdate";
    }

    @PostMapping("/files/selectCover/{postId}/{fileId}")
    public String selectCover(
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable Long postId,
            @PathVariable Long fileId
    ) {
        Response response = fileService.updateCover(fileId, postId);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/files/update/" + postId + "";
    }

    @PostMapping("/files/updateFile/{postId}")
    public String updateFile(
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable Long postId,
            @NotNull @RequestParam("files") List<MultipartFile> files
    ) {
        if (files.size() != 0) {
            Response response = fileService.updateFiles(postId, files);
            redirectAttributes.addFlashAttribute("response", response);
        }
        return "redirect:/files/update/" + postId + "";
    }

    @PostMapping("/files/deleteFile/{postId}/{fileId}")
    public String deleteFile(
            @NotNull final RedirectAttributes redirectAttributes,
            @PathVariable Long postId,
            @PathVariable Long fileId
    ) {
        Response response = fileService.deleteFile(postId, fileId);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/files/update/" + postId + "";
    }

}

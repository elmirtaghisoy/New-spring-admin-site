package com.cb.colorbrain.controller;

import com.cb.colorbrain.model.Categorie;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.service.CategorieService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/category")
    public String getAllCategory(
            final Response response,
            final BindingResult bindingResult,
            @NotNull final RedirectAttributes redirectAttributes,
            @NotNull Model model
    ) {
        model.addAttribute("categoryList", categorieService.getAllCategorie());
        redirectAttributes.addFlashAttribute("response", response);
        return "categoryAll";
    }

    @PostMapping("/category/add")
    public String addCategory(
            @Valid Categorie category,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = categorieService.addCategory(category);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/category";
    }

    @PostMapping("/category/update/{catId}")
    public String updateCategory(
            @PathVariable("catId") Categorie categorie,
            @RequestParam("catName") String catName,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = categorieService.updateCategory(categorie, catName);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/category";
    }

    @PostMapping("/category/delete/{catId}")
    public String deleteCategory(
            @PathVariable("catId") Categorie categorie,
            @NotNull final RedirectAttributes redirectAttributes
    ) {
        Response response = categorieService.deleteCategory(categorie);
        redirectAttributes.addFlashAttribute("response", response);
        return "redirect:/category";
    }
}

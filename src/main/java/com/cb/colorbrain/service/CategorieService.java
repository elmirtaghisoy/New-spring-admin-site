package com.cb.colorbrain.service;

import com.cb.colorbrain.model.Categorie;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.repository.CategorieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAllByActiveTrue();
    }

    public Response addCategory(@NotNull Categorie category) {
        if (category.getCatName() != null) {
            categorieRepository.save(category);
            return new Response("Kateqoriya əlavə edildi", 1);
        } else
            return new Response("Xəta", 0);
    }

    public Response updateCategory(@NotNull Categorie categorie, String catName) {
        if (categorie.getId() != null && catName != null) {
            try {
                Categorie categorieFromDb = categorieRepository.getOne(categorie.getId());
                categorieFromDb.setCatName(catName);
                categorieRepository.save(categorieFromDb);
                return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response("Xəta", 0);
            }
        } else
            return new Response("Xəta", 0);
    }

    public Response deleteCategory(@NotNull Categorie categorie) {
        if (categorie.getId() != null) {
            try {
                Categorie categorieFromDb = categorieRepository.getOne(categorie.getId());
                categorieFromDb.setActive(false);
                categorieRepository.save(categorieFromDb);
                return new Response("Kateqoriya uğurla silindi", 1);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response("Xəta", 0);
            }
        } else {
            return new Response("Xəta", 0);
        }
    }
}

package com.cb.colorbrain.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String catName;
    private boolean active = true;

    @OneToMany(targetEntity = Post.class, mappedBy = "catId")
    private Collection<Post> postsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }
}

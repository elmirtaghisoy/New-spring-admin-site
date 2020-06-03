package com.cb.colorbrain.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String header;
    private String context;
    private Integer views;
    private Integer likes;
    @Column(name = "cat_id")
    private Long catId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "team_id")
    private Long teamId;
    private LocalDateTime date;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team teamByTeamId;

    @OneToMany(targetEntity = File.class, mappedBy = "postId")
    private Collection<File> filesById;

    @ManyToOne
    @JoinColumn(name = "cat_id", insertable = false, updatable = false)
    private Categorie categorieByCatId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User userByAuthorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUserByAuthorId() {
        return userByAuthorId;
    }

    public void setUserByAuthorId(User userByAuthorId) {
        this.userByAuthorId = userByAuthorId;
    }

    public Categorie getCategorieByCatId() {
        return categorieByCatId;
    }

    public void setCategorieByCatId(Categorie categorieByCatId) {
        this.categorieByCatId = categorieByCatId;
    }

    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    public Collection<File> getFilesById() {
        return filesById;
    }

    public void setFilesById(Collection<File> filesById) {
        this.filesById = filesById;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", context='" + context + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", catId=" + catId +
                ", userId=" + userId +
                ", teamId=" + teamId +
                ", date=" + date +
                ", active=" + active +
                ", teamByTeamId=" + teamByTeamId +
                ", filesById=" + filesById +
                ", categorieByCatId=" + categorieByCatId +
                ", userByAuthorId=" + userByAuthorId +
                '}';
    }
}

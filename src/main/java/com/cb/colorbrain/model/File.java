package com.cb.colorbrain.model;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer path;
    private String fileName;
    private Integer queue;
    private Integer fileType;
    @Column(name = "post_Id")
    private Long postId;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post postByPostId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPath() {
        return path;
    }

    public void setPath(Integer path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Post getPostByPostId() {
        return postByPostId;
    }

    public void setPostByPostId(Post postByPostId) {
        this.postByPostId = postByPostId;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", path=" + path +
                ", fileName='" + fileName + '\'' +
                ", queue=" + queue +
                ", fileType=" + fileType +
                ", postId=" + postId +
                ", active=" + active +
                ", postByPostId=" + postByPostId +
                '}';
    }
}

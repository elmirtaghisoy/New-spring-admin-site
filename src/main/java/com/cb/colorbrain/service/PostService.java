package com.cb.colorbrain.service;

import com.cb.colorbrain.model.Post;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.repository.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FileService fileService;

    public Page<Post> getAllPostByTeamId(Pageable pageable, Long teamId) {
        return postRepository.findAllByActiveTrueAndTeamId(pageable, teamId);
    }

    public Page<Post> getAllPost(Pageable pageable) {
        return postRepository.findAllByActiveTrue(pageable);
    }

    public Response addPost(Long teamId, @NotNull Post post, List<MultipartFile> files) {
        try {
            post.setTeamId(teamId);
            post.setDate(LocalDateTime.now());
            postRepository.save(post);
            fileService.saveMultiple(post, files);
            return new Response("Paylaşım yerinə yetirildi", 1);
        } catch (IOException e) {
            e.printStackTrace();
            return new Response("Faylların yüklənməsində xəta baş verdi", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public Post getPostById(Long postId) {
        return postRepository.findByActiveTrueAndId(postId);
    }

    public Response updatePost(@NotNull Post post) {
        try {
            Post postFromDb = postRepository.getOne(post.getId());
            setPostData(post, postFromDb);
            postRepository.save(postFromDb);
            return new Response("Dəyişiklik uğurla yerinə yerinə yetirildi", 1);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public Page<Post> getPostByUserId(Pageable pageable, Long userId) {
        return postRepository.findAllByActiveTrueAndUserId(pageable, userId);
    }

    private void setPostData(@NotNull Post post, @NotNull Post postFromDb) {
        postFromDb.setCatId(post.getCatId());
        postFromDb.setHeader(post.getHeader());
        postFromDb.setContext(post.getContext());
        postFromDb.setUserId(post.getUserId());
    }
}

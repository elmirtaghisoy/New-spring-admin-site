package com.cb.colorbrain.repository;

import com.cb.colorbrain.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByActiveTrueAndTeamId(Pageable pageable, Long teamId);

    Page<Post> findAllByActiveTrue(Pageable pageable);

    Post findByActiveTrueAndId(Long postId);

    Page<Post> findAllByActiveTrueAndUserId(Pageable pageable, Long userId);
}

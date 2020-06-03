package com.cb.colorbrain.repository;

import com.cb.colorbrain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepoository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);

    List<User> findAllByTeamId(Long teamId);

    Page<User> findAllByTeamId(Pageable pageable, Long teamId);

    Page<User> findAllByActiveTrue(Pageable pageable);
}

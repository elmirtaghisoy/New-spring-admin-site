package com.cb.colorbrain2.repository;

import com.cb.colorbrain2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}

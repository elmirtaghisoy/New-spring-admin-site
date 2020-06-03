package com.cb.colorbrain.repository;

import com.cb.colorbrain.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Page<Project> findAllByActiveTrueAndStatusAndTeamId(Pageable pageable, int status, Long teamId);

    Page<Project> findAllByActiveTrueAndStatus(Pageable pageable, int status);

    Project findByActiveTrueAndId(Long projectId);

}

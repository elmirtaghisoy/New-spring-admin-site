package com.cb.colorbrain.repository;

import com.cb.colorbrain.model.Project;
import com.cb.colorbrain.model.ProjectCreator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProjectCreatorRepository extends JpaRepository<ProjectCreator, Long> {

    List<ProjectCreator> findAllByActiveTrueAndProjectId(Long projectId);

    List<ProjectCreator> findByActiveTrueAndProjectId(Long projectId);

    @Modifying
    @Transactional
    @Query("delete from ProjectCreator pc where pc.projectId = ?1")
    void deleteByActiveTrueAndProjectId(Long id);

    Page<ProjectCreator> findAllByActiveTrueAndUserId(Pageable pageable,Long userId);

}

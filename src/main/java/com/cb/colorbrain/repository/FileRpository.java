package com.cb.colorbrain.repository;

import com.cb.colorbrain.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FileRpository extends JpaRepository<File, Long> {
    List<File> getAllByActiveTrueAndPostIdOrderByQueueAsc(Long postId);

    @Modifying
    @Transactional
    @Query("update File f set f.queue = 0 where f.postId = ?1")
    void refreshQueue(Long postId);
}

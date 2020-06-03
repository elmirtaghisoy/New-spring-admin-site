package com.cb.colorbrain.repository;

import com.cb.colorbrain.model.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Page<Applicant> findAllByActiveTrue(Pageable pageable);

    Page<Applicant> findAllByActiveTrueAndTeamId(Pageable pageable, Long teamId);

    Applicant findByActiveTrueAndId(Long applicantId);

    Applicant findByActivationCode(String token);
}

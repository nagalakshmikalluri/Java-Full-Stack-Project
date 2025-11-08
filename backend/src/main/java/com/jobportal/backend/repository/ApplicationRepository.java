package com.jobportal.backend.repository;

import com.jobportal.backend.model.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    List<ApplicationEntity> findByUserUserId(Long userId);
    List<ApplicationEntity> findByJobJobId(Long jobId);
}


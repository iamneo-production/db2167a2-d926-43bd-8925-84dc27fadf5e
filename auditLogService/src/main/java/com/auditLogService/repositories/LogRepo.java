package com.auditLogService.repositories;

import com.auditLogService.entities.LogDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<LogDetail,String> {
}

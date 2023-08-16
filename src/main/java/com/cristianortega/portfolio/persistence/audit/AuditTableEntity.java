package com.cristianortega.portfolio.persistence.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;

@MappedSuperclass
public class AuditTableEntity {

    @Column(name = "create_by")
    @CreatedBy
    private String createdBy;

}

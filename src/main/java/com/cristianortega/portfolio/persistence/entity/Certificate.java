package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.audit.AuditTableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "certificate")
@Getter
@Setter
@NoArgsConstructor

public class Certificate extends AuditTableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificate", nullable = false)
    private Integer idCertificate;

    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String entity;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime completed;

    @Column(nullable = false, length = 300)
    private String smallImage;

    @Column(nullable = false, length = 300)
    private String bigImage;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

}

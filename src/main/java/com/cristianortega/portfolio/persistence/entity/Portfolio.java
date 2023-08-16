package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.audit.AuditTableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "portfolio")
@EntityListeners({ AuditingEntityListener.class })
@Getter
@Setter
@NoArgsConstructor
public class Portfolio extends AuditTableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_portfolio", nullable = false)
    private Integer idPortfolio;

    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(name = "client_name", length = 100)
    private String clientName;

    @Column(nullable = false, length = 300)
    private String image;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "repository_url", length = 100)
    private String repositoryUrl;

    @Column(name = "demo_url", length = 100)
    private String demoUrl;

    @Column(name = "working_from", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime workingFrom;

    @Column(name = "working_to", columnDefinition = "DATETIME")
    private LocalDateTime workingTo;

    @Column(name = "publish", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime publishDate;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "portfolio_technology",
            joinColumns = @JoinColumn(name = "id_portfolio"),
            inverseJoinColumns = @JoinColumn(name = "id_technology"))
    private List<Technology> portfolioTechnologies;

}

package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.config.StringArraySlashConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "portfolio")
@Getter
@Setter
@NoArgsConstructor
public class Portfolio {

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

    @Convert(converter = StringArraySlashConverter.class)
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String[] description;

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

    @ManyToMany
    @JoinTable(
            name = "portfolio_technology",
            joinColumns = @JoinColumn(name = "id_portfolio"),
            inverseJoinColumns = @JoinColumn(name = "id_technology"))
    private List<Technology> portfolioTechnologies;

}

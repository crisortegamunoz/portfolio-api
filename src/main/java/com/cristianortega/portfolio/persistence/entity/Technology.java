package com.cristianortega.portfolio.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "technology")
@Getter
@Setter
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_technology", nullable = false)
    private Integer idTechnology;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(length = 20)
    private String version;

    @OneToMany(mappedBy="technology", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Skill> skills;

    @ManyToMany(mappedBy = "portfolioTechnologies", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Portfolio> portfolios;

    @ManyToMany(mappedBy = "experienceTechnologies", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Experience> experiences;
}

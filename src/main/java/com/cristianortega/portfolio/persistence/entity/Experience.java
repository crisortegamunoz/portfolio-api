package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.config.StringArrayDelimiterConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experience", nullable = false)
    private Integer idExperience;

    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(length = 100)
    private String role;

    @Column(length = 1000)
    private String roleDescription;

    @Column(nullable = false, length = 200)
    private String entity;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(length = 4000)
    private String entityDescripcion;

    @Convert(converter = StringArrayDelimiterConverter.class)
    @Column(name = "responsabilities", columnDefinition = "TEXT", nullable = false)
    private String[] responsibilities;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "experience_technology",
            joinColumns = @JoinColumn(name = "id_experience"),
            inverseJoinColumns = @JoinColumn(name = "id_technology"))
    private List<Technology> experienceTechnologies;

}

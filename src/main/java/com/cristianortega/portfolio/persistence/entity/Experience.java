package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.util.StringArrayConverter;
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

    @Column(nullable = false, length = 50)
    private String role;

    @Column(length = 1000)
    private String roleDescription;

    @Column(nullable = false, length = 70)
    private String entity;

    @Column(length = 4000)
    private String entityDescripcion;

    @Convert(converter = StringArrayConverter.class)
    @Column(name = "responsabilities", columnDefinition = "TEXT", nullable = false)
    private String[] responsabilities;

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

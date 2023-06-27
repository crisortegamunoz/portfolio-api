package com.cristianortega.portfolio.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skill")
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill", nullable = false)
    private Integer idSkill;

    @Column(name = "id_technology", nullable = false)
    private Integer idTechnology;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean available;

    @Column(nullable = false)
    private Integer percentage;

    @Column(nullable = false, length = 50)
    private String css;

    @Column(nullable = false, length = 50)
    private String style;

    @ManyToOne
    @JoinColumn(name = "id_technology", referencedColumnName = "id_technology", insertable = false, updatable = false)
    @JsonIgnore
    private Technology technology;

}

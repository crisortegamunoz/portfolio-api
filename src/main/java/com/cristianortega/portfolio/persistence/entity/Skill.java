package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
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
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean show;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Section section;


}

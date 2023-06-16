package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Section section;

}

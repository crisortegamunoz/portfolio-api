package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Section section;

    @OneToMany(mappedBy="category")
    public List<Certificate> certificates;

    @OneToMany(mappedBy="category")
    public List<Experience> experiences;

}

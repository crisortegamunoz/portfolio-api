package com.cristianortega.portfolio.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "knowlegde")
@Getter
@Setter
@NoArgsConstructor
public class Knowlegde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_knowlegde", nullable = false)
    private Integer idKnowlegde;

    @Column(nullable = false, length = 50)
    private String name;

}

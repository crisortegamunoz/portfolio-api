package com.cristianortega.portfolio.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "certificate")
@Getter
@Setter
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 25)
    private String entity;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime completed;

    @Column(nullable = false, length = 300)
    private String smallImage;

    @Column(nullable = false, length = 300)
    private String bigImage;



}

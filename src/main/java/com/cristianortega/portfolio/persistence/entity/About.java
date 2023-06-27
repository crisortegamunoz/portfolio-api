package com.cristianortega.portfolio.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "about")
@Getter
@Setter
@NoArgsConstructor
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_about", nullable = false)
    private Integer idAbout;

    @Column(nullable = false, length = 4000)
    private String description;

    @OneToMany(mappedBy = "about", fetch = FetchType.EAGER)
    private List<AboutBox> boxes;


}

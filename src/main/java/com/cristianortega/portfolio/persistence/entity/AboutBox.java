package com.cristianortega.portfolio.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "about_box")
@Getter
@Setter
@NoArgsConstructor
public class AboutBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aboutbox", nullable = false)
    private Integer idAboutBox;

    @Column(nullable = false, length = 40)
    private String title;

    @Column(nullable = false, length = 300)
    private String description;

    @Column(nullable = false, length = 200)
    private String css;

    @Column(nullable = false, length = 300)
    private String image;

    @Column(nullable = false)
    private Integer orderDisplay;

    @ManyToMany(mappedBy = "aboutBoxes", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<About> abouts;

}

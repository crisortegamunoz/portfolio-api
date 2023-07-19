package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.config.StringArraySlashConverter;
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

    @Column(nullable = false, length = 40)
    private String title;

    @Convert(converter = StringArraySlashConverter.class)
    @Column(nullable = false, length = 4000)
    private String[] descriptions;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
            name = "about_boxes",
            joinColumns = @JoinColumn(name = "id_about"),
            inverseJoinColumns = @JoinColumn(name = "id_aboutbox"))
    private List<AboutBox> aboutBoxes;


}

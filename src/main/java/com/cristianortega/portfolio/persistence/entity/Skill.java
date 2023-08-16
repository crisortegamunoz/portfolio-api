package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.audit.AuditTableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name = "skill")
@EntityListeners({ AuditingEntityListener.class })
@Getter
@Setter
public class Skill extends AuditTableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill", nullable = false)
    private Integer idSkill;

    @Column(name = "id_technology")
    private Integer idTechnology;

    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean available;

    @Column(length = 60)
    private String name;

    @Column
    private Integer percentage;

    @Column(length = 300)
    private String css;

    @Column(length = 300)
    private String style;

    @ManyToOne
    @JoinColumn(name = "id_technology", referencedColumnName = "id_technology", insertable = false, updatable = false)
    @JsonIgnore
    private Technology technology;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

}

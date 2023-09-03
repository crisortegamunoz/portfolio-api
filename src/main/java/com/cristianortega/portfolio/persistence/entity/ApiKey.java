package com.cristianortega.portfolio.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "apikey")
@Getter
@Setter
@NoArgsConstructor
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apikey", nullable = false)
    private Integer idApiKey;
    @Column(nullable = false, length = 300)
    private String username;
    @Column(nullable = false, length = 300)
    private String code;

}

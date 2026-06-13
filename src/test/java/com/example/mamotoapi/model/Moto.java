package com.example.mamotoapi.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "motos ")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String marca;
    private String modelo;
    private Integer ano;
    private Integer cilindradas;
    private Integer quilometragem;
    private String cor;

    @Column(length = 1000)
    private String descricao;

    private String imagemUrl;

    @Enumerated(EnumType.STRING)
    private StatusMoto status;
}

package com.bookstore.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Integer id;
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String nacionalidade;
    @Column(name = "obras_principais")
    private String obrasPrincipais;

}
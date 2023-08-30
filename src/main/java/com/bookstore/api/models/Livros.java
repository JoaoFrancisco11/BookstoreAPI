package com.bookstore.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
    private Integer id;
    private String isbn;
    private String titulo;
    private String editora;
    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;
    private String genero;
    @Column(name = "num_copias_disponiveis")
    private Integer numCopiasDisponiveis;
    private String localizacao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autores autor_id;

}

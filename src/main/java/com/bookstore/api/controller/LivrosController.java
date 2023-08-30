package com.bookstore.api.controller;

import com.bookstore.api.models.Livros;
import com.bookstore.api.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/livros")
@RestController
public class LivrosController {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping
    public ResponseEntity<List<Livros>> consultarAutores(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.findAll());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Livros>> consultarPorLivro(@PathVariable("titulo") final String titulo){
        List<Livros> livroEncontrado = livrosRepository.findByTitulo(titulo);
        if(livroEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(livroEncontrado);
    }
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<List<Livros>> consultaPorIsbn(@PathVariable("isbn") final String isbn){
        List<Livros> isbnEncontrado = livrosRepository.findByIsbn(isbn);
        if(isbnEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(isbnEncontrado);
    }

}

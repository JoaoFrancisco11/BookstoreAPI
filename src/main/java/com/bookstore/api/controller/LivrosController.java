package com.bookstore.api.controller;

import com.bookstore.api.models.Livros;
import com.bookstore.api.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}

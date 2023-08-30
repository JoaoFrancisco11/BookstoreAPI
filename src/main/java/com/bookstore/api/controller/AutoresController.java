package com.bookstore.api.controller;

import com.bookstore.api.models.Autores;
import com.bookstore.api.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/autores")
@RestController
public class AutoresController {

    @Autowired
    private AutoresRepository autoresRepository;

    @GetMapping
    public ResponseEntity<List<Autores>> consultarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(autoresRepository.findAll());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Autores>> consultarPorNome(@PathVariable("nome") final String nome){
        List<Autores> nomeEncontrado = autoresRepository.findByNome(nome);
        if(nomeEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(nomeEncontrado);
    }

}

package com.bookstore.api.repository;

import com.bookstore.api.models.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {
}
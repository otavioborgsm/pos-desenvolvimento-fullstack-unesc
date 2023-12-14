package io.github.otavioborgsm.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.otavioborgsm.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    
}

package io.github.otavioborgsm.biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.otavioborgsm.biblioteca.model.Livro;
import io.github.otavioborgsm.biblioteca.service.LivroService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> obterTodos(){
        return livroService.obterTodos();
    }

    @PostMapping
    public Livro adicionar(@RequestBody Livro livro){
        return livroService.adicionar(livro);
    }

    @GetMapping("/{id}")
    public Optional<Livro> obterPorId(@PathVariable Integer id){
        return livroService.obterPorId(id);
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Integer id){
        livroService.remover(id);
        return "O livro com id " + id + " foi removido com sucesso";
    }

    @PutMapping("/{id}")
    public Livro atualizar(@RequestBody Livro livro, @PathVariable Integer id){
        return livroService.atualizar(id, livro);
    }

}

package io.github.otavioborgsm.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.otavioborgsm.biblioteca.model.Livro;
import io.github.otavioborgsm.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;


    /**
     * Retorna todos os livros cadastrados
     * @return Lista de livros
     */
    public List<Livro> obterTodos(){
        return livroRepository.obterTodos();
    }

    /**
     * Metodo para retornar um livro baseado no ID.
     * @param id do livro a ser pesquisado
     * @return retorna um livro
     */
    public Optional<Livro> obterPorId(Integer id){
        return livroRepository.obterPorId(id);
    }

    /**
     * Adiciona um novo livro
     * @param livro a ser adicionado
     * @return livro adicionado
     */
    public Livro adicionar(Livro livro){
        return livroRepository.adicionar(livro);
    }

    /**
     * Remove livro por ID
     * @param id do Livro a ser removido
     */
    public void remover(Integer id){
        livroRepository.remover(id);
    }

    /**
     * Atualiza livro
     * @param id do Livro que será atualizado
     * @param livro a ser atualizado
     * @return livro atualizado
     */
    public Livro atualizar(Integer id, Livro livro){
        livro.setId(id);
        return livroRepository.atualizar(livro);
    }
}

package io.github.otavioborgsm.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import io.github.otavioborgsm.biblioteca.model.Livro;
import io.github.otavioborgsm.biblioteca.model.exception.ResourceNotFoundException;

@Repository
public class LivroRepository {
    
    private List<Livro> livros = new ArrayList<Livro>();
    private Integer ultimoLivro = 0;

    /**
     * Retorna todos os livros cadastrados
     * @return Lista de livros
     */
    public List<Livro> obterTodos(){
        return livros;
    }

    /**
     * Metodo para retornar um livro baseado no ID.
     * @param id do livro a ser pesquisado
     * @return retorna um livro
     */
    public Optional<Livro> obterPorId(Integer id){
        return livros
            .stream()
            .filter(livro -> livro.getId() == id)
            .findFirst();
    }

    /**
     * Adiciona um novo livro
     * @param livro a ser adicionado
     * @return livro adicionado
     */
    public Livro add(Livro livro){
        livros.add(livro);
        return livro;
    }

    public Livro adicionar(Livro livro){
        ultimoLivro++;
        livro.setId(ultimoLivro);
        return add(livro);
    }

    /**
     * Remove livro por ID
     * @param id do Livro a ser removido
     */
    public void remover(Integer id){
        livros.removeIf(livro -> livro.getId() == id);
    }

    /**
     * Metodo para atualizar um livro
     * @param livro a ser atualizado
     * @return o livro atualizado
     */
    public Livro atualizar(Livro livro){

        Optional<Livro> livroEncontrado = obterPorId(livro.getId());

        if (livroEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Livro não encontrado");
        }

        remover(livro.getId());
        return add(livro);
    }
}

package io.github.otavioborgsm.biblioteca.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.otavioborgsm.biblioteca.model.Livro;
import io.github.otavioborgsm.biblioteca.model.exception.ResourceNotFoundException;
import io.github.otavioborgsm.biblioteca.repository.LivroRepository;
import io.github.otavioborgsm.biblioteca.shared.LivroDTO;

@Service
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;


    /**
     * Retorna todos os livros cadastrados
     * @return Lista de livros
     */
    public List<LivroDTO> obterTodos(){
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
            .map(livro -> new ModelMapper().map(livro, LivroDTO.class))
            .collect(Collectors.toList());
    }

    /**
     * Metodo para retornar um livro baseado no ID.
     * @param id do livro a ser pesquisado
     * @return retorna um livro
     */
    public Optional<LivroDTO> obterPorId(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            throw new ResourceNotFoundException("Livro com Id " + id + " inexistente");
        }

        LivroDTO livroDTO = new ModelMapper().map(livro.get(), LivroDTO.class);
        return Optional.of(livroDTO);
    }

    /**
     * Adiciona um novo livro
     * @param livro a ser adicionado
     * @return livro adicionado
     */
    public LivroDTO adicionar(LivroDTO livroDTO){

        livroDTO.setId(null);
        ModelMapper mapper = new ModelMapper();
        Livro livro = mapper.map(livroDTO, Livro.class);
        livro = livroRepository.save(livro);
        livroDTO.setId(livro.getId());

        return livroDTO;
    }

    /**
     * Remove livro por ID
     * @param id do Livro a ser removido
     */
    public void remover(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            throw new ResourceNotFoundException("Livro com Id " + id + " inexistente");
        }

        livroRepository.deleteById(id);
    }

    /**
     * Atualiza livro
     * @param id do Livro que será atualizado
     * @param livroDTO a ser atualizado
     * @return livro atualizado
     */
    public LivroDTO atualizar(Integer id, LivroDTO livroDTO){
        livroDTO.setId(id);

        ModelMapper mapper = new ModelMapper();

        Livro livro = mapper.map(livroDTO, Livro.class);

        livroRepository.save(livro);

        return livroDTO;
    }
}

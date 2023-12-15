package io.github.otavioborgsm.biblioteca.view.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.otavioborgsm.biblioteca.model.Livro;
import io.github.otavioborgsm.biblioteca.service.LivroService;
import io.github.otavioborgsm.biblioteca.shared.LivroDTO;
import io.github.otavioborgsm.biblioteca.view.model.LivroRequest;
import io.github.otavioborgsm.biblioteca.view.model.LivroResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<LivroResponse>> obterTodos(){
        List<LivroDTO> livros = livroService.obterTodos();
        ModelMapper mapper = new ModelMapper();
        List<LivroResponse> resposta = livros.stream()
            .map(livroDTO -> mapper.map(livroDTO, LivroResponse.class))
            .collect(Collectors.toList());
        
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LivroResponse> adicionar(@RequestBody LivroRequest livro){
        // return livroService.adicionar(livro);
        ModelMapper mapper = new ModelMapper();
        LivroDTO livroDTO = mapper.map(livro, LivroDTO.class);
        livroDTO = livroService.adicionar(livroDTO);
        return new ResponseEntity<>(mapper.map(livroDTO, LivroResponse.class), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroResponse>> obterPorId(@PathVariable Integer id){
        Optional<LivroDTO> livroDTO = livroService.obterPorId(id);
        LivroResponse livro = new ModelMapper().map(livroDTO, LivroResponse.class);

        return new ResponseEntity<>(Optional.of(livro), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id){
        livroService.remover(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> atualizar(@RequestBody LivroRequest livro, @PathVariable Integer id){
        // return livroService.atualizar(id, livro);
        ModelMapper mapper = new ModelMapper();
        LivroDTO livroDTO = mapper.map(livro, LivroDTO.class);
        livroDTO = livroService.atualizar(id, livroDTO);

        return new ResponseEntity<>(
            mapper.map(livroDTO, LivroResponse.class),
            HttpStatus.OK
            );
    }

}

package br.com.couto.converttodto.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.couto.converttodto.dtos.PokemonDtoInterface;
import br.com.couto.converttodto.models.Pokemon;
import br.com.couto.converttodto.services.podedexService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pokedex")
@RequiredArgsConstructor
public class PokedexController {

    private final podedexService podedexService;


    @GetMapping("/{id}")
    public Page<PokemonDtoInterface> findPokemon(@PathVariable("id") Long id, Pageable pageable){
        return podedexService.findById(id, pageable);
    }
    
    @GetMapping
    public Page<Pokemon> findByExample(Pageable pageable){
        return podedexService.findByExample(pageable);
    }

}
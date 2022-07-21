package br.com.couto.converttodto.services;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.couto.converttodto.dtos.PokemonDtoInterface;
import br.com.couto.converttodto.models.Pokemon;
import br.com.couto.converttodto.repositories.PokedexRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class podedexService {
	
	private final PokedexRepository pokedexRepository;

	//a busca conver pra DTO(Interface)
	public Page<PokemonDtoInterface> findById(Long id, Pageable pageable) {
		return pokedexRepository.findPokemon(id, pageable);
    }

	//Realiza a busca de acordo com o exemplo passado
	public Page<Pokemon> findByExample(Pageable pageable) {
		Example<Pokemon> exemploParaBuscar = Example.of(Pokemon.builder().id(2L).build());
		return pokedexRepository.findAll(exemploParaBuscar, pageable);
	}


}

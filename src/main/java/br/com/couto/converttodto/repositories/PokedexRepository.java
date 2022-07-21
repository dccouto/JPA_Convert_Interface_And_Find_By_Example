package br.com.couto.converttodto.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.couto.converttodto.dtos.PokemonDtoInterface;
import br.com.couto.converttodto.models.Pokemon;

public interface PokedexRepository extends JpaRepository<Pokemon, Long> {
	
	@Query("select p from Pokemon p where p.id = :id")
	Page<PokemonDtoInterface> findPokemon(Long id, Pageable pageable);
	
}

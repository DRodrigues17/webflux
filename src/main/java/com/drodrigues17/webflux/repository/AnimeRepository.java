package com.drodrigues17.webflux.repository;

import com.drodrigues17.webflux.model.Anime;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnimeRepository extends ReactiveCrudRepository<Anime, Integer> {
}

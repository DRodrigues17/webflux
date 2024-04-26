package com.drodrigues17.webflux.service;

import com.drodrigues17.webflux.model.Anime;
import com.drodrigues17.webflux.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class AnimeService {
  private final AnimeRepository animeRepository;


  public Flux<Anime> buscarTodosAnimes() {
    return animeRepository.findAll();
  }
}

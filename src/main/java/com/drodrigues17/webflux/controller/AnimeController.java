package com.drodrigues17.webflux.controller;

import com.drodrigues17.webflux.model.Anime;
import com.drodrigues17.webflux.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/animes")
public class AnimeController {
  private final AnimeService animeService;


  @GetMapping
  public Flux<Anime> buscarTodosAnimes() {
    return animeService.buscarTodosAnimes();
  }

  @GetMapping(path = "/{id}")
  public Mono<Anime> buscarAnimePorid(@PathVariable Integer id) {
    return animeService.buscarAnimePorId(id);
  }
}

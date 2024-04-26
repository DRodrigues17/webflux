package com.drodrigues17.webflux.controller;

import com.drodrigues17.webflux.model.Anime;
import com.drodrigues17.webflux.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/animes")
public class AnimeController {
  private final AnimeService animeService;


  @GetMapping
  public Flux<Anime> buscarTodosAnimes() {
    return animeService.buscarTodosAnimes();
  }
}

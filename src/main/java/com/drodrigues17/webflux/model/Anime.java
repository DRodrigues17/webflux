package com.drodrigues17.webflux.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Anime {
  @Id
  private Long id;
  @NotBlank(message = "nome não pode ser nulo")
  private String nome;


}

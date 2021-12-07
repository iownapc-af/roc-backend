package com.porfolio.portfolio.Player;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
  private final PlayerRepository repository;
  private final PlayerService service;

  public PlayerController(PlayerRepository repository, PlayerService service) {
    this.repository = repository;
    this.service = service;
  }

  @PutMapping(path = "/api/player/{key}",  produces = MediaType.APPLICATION_JSON_VALUE)
  PlayerEntity updatePlayer(@PathVariable String key) {
    PlayerEntity result = repository.save(service.movePlayer(key));

    return result;
  }
}

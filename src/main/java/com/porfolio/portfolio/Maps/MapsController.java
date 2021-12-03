package com.porfolio.portfolio.Maps;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapsController {
  private final MapsRepository repository;
  private final MapsService service;

  public MapsController(MapsRepository repository, MapsService service) {
    this.repository = repository;
    this.service = service;
  }

  @GetMapping(path = "/api/map/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public MapsResponse getMapContents(@PathVariable Integer id) {
    return new MapsResponse(service.getMapContents(id));
  }
}

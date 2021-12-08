package com.porfolio.portfolio.Maps.Door;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoorController {
  private final DoorRepository repository;
  private final DoorService service;

  public DoorController(DoorRepository repository, DoorService service) {
    this.repository = repository;
    this.service = service;
  }

  
}

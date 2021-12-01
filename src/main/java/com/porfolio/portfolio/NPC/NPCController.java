package com.porfolio.portfolio.NPC;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NPCController {
  private final NPCRepository repository;
  private final NPCService service;

  public NPCController(NPCRepository npcRepository, NPCService service) {
    this.repository = npcRepository;
    this.service = service;
  }

  @GetMapping(path = "/api/npcs", produces = MediaType.APPLICATION_JSON_VALUE)
  public NPCResponse getAllNPC() {
    return new NPCResponse(repository.findAll());
  }

  @GetMapping(path = "/api/npc-moving", produces = MediaType.APPLICATION_JSON_VALUE)
  public NPCResponse getNPCsFromMemory() {
    return new NPCResponse(service.getNPCPositions());
  }

  @PostMapping(path = "/api/npc")
  public ResponseEntity<String> createNPC(@RequestBody NPCEntity newNPC) {
    repository.save(newNPC);
    return ResponseEntity.ok().build();
  }

  @PutMapping(path = "/api/npc/{id}")
  ResponseEntity<NPCEntity> updateNPC(@RequestBody NPCEntity npc) {
    NPCEntity result = repository.save(npc);
    return ResponseEntity.ok().body(result);
  }

  @DeleteMapping(path = "/api/npc/{id}")
  public ResponseEntity<?> deleteNPC(@PathVariable UUID id) {
    repository.deleteById(id);
    return ResponseEntity.ok().build();
  }
}

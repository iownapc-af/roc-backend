package com.porfolio.portfolio.NPC;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NPCRepository extends JpaRepository<NPCEntity, UUID>{
  List<NPCEntity> findAllByOrderByName();
}

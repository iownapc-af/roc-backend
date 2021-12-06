package com.porfolio.portfolio.NPC;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.porfolio.portfolio.Maps.MapsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NPCService {
  NPCRepository npcRepository;
  List<NPCEntity> allNpcs;

  @Autowired
  MapsService mapService;

  NPCService(NPCRepository npcRepository) {
    this.npcRepository = npcRepository;
    this.allNpcs = npcRepository.findAllByOrderByName();
  }

  SecureRandom numberGenerator = new SecureRandom();

  @Scheduled(fixedRate = 500)
  private void moveNPC() {
    // this.allNpcs = npcRepository.findAllByOrderByName();

    int moveDirection;

    ArrayList<NPCEntity> allNpcsToMove = new ArrayList<>();

    for (int entity = 0; entity < allNpcs.size(); entity++) {
      moveDirection = numberGenerator.nextInt(6);
      NPCEntity npcToMove = allNpcs.get(entity);

      Integer npcXCoord = npcToMove.getXCoordinate();
      Integer npcYCoord = npcToMove.getYCoordinate();

      allNpcsToMove.add(npcToMove);

      switch (moveDirection) {
        case 0: // up
          if (mapService.isValidMovementTile(npcXCoord, npcYCoord - 20, this.allNpcs))
            npcToMove.setYCoordinate(npcYCoord - 20);
          break;
        case 1: // down
          if (mapService.isValidMovementTile(npcXCoord, npcYCoord + 20, this.allNpcs))
            npcToMove.setYCoordinate(npcYCoord + 20);
          break;
        case 2: // left
          if (mapService.isValidMovementTile(npcXCoord - 20, npcYCoord, this.allNpcs))
            npcToMove.setXCoordinate(npcXCoord - 20);
          break;
        case 3: // right
          if (mapService.isValidMovementTile(npcXCoord + 20, npcYCoord, this.allNpcs))
            npcToMove.setXCoordinate(npcXCoord + 20);
          break;
        case 4: // Doesn't move if 4/5 are rolled
        case 5:
          break;
      }
    }

    // npcRepository.saveAll(allNpcsToMove);
    this.allNpcs = allNpcsToMove;
  }

  List<NPCEntity> getNPCPositions() {
    return this.allNpcs;
  }
}

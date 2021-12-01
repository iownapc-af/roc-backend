package com.porfolio.portfolio.NPC;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NPCService {
  NPCRepository npcRepository;
  List<NPCEntity> allNpcs;

  NPCService(NPCRepository npcRepository) {
    this.npcRepository = npcRepository;
    this.allNpcs = npcRepository.findAll();
  }

  SecureRandom numberGenerator = new SecureRandom();
  
  @Scheduled(fixedRate = 250)
  private void moveNPC() {
    int moveDirection;

    ArrayList<NPCEntity> allNpcsToMove = new ArrayList<>();

    for (int entity = 0; entity < allNpcs.size(); entity++) {
      moveDirection = numberGenerator.nextInt(6);
      NPCEntity npcToMove = allNpcs.get(entity);

      Integer npcXCoord = npcToMove.getXCoordinate();
      Integer npcYCoord = npcToMove.getYCoordinate();

      switch (moveDirection) {
        case 0: // up
          if (npcYCoord - 20 > 20) {
            npcToMove.setYCoordinate(npcYCoord - 20);
          } else {
            npcToMove.setYCoordinate(20);
          }
          break;
        case 1: // down
          if (npcYCoord + 20 < 580) {
            npcToMove.setYCoordinate(npcYCoord + 20);
          } else {
            npcToMove.setYCoordinate(580);
          }
          break;
        case 2: // left
          if (npcXCoord - 20 > 20) {
            npcToMove.setXCoordinate(npcXCoord - 20);
          } else {
            npcToMove.setXCoordinate(20);
          }
          break;
        case 3: // right
          if (npcXCoord + 20 < 780) {
            npcToMove.setXCoordinate(npcXCoord + 20);
          } else {
            npcToMove.setXCoordinate(780);
          }
          break;
        case 4: // Doesn't move if 4/5 are rolled
        case 5:
          break;
      }

      allNpcsToMove.add(npcToMove);
    }

    allNpcs = allNpcsToMove;
  }

  List<NPCEntity> getNPCPositions() {
    return this.allNpcs;
  }
}

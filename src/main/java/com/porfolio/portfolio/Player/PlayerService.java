package com.porfolio.portfolio.Player;

import java.util.HashMap;
import java.util.List;

import com.porfolio.portfolio.Maps.MapsService;
import com.porfolio.portfolio.NPC.NPCEntity;
import com.porfolio.portfolio.NPC.NPCService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
  PlayerRepository playerRepository;

  @Autowired
  MapsService mapsService;

  @Autowired
  NPCService npcService;

  PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public Integer[] playerMovement(String playerDirection) {
    PlayerEntity player = playerRepository.getById(0);
    Integer playerXCoord = player.getXCoordinate();
    Integer playerYCoord = player.getYCoordinate();

    Integer playerUpCoord = playerYCoord - 20;
    Integer playerDownCoord = playerYCoord + 20;
    Integer playerLeftCoord = playerXCoord - 20;
    Integer playerRightCoord = playerXCoord + 20;

    HashMap<String, Integer[]> direction = new HashMap<String, Integer[]>();
    direction.put("north", new Integer[] { playerXCoord, playerUpCoord });
    direction.put("south", new Integer[] { playerXCoord, playerDownCoord });
    direction.put("east", new Integer[] { playerRightCoord, playerYCoord });
    direction.put("west", new Integer[] { playerLeftCoord, playerYCoord });

    return direction.get(playerDirection);
  }

  public PlayerEntity movePlayer(String key) {
    PlayerEntity player = playerRepository.findById(0).get();
    
    List<NPCEntity> allNpcs = npcService.getNPCPositions();

    switch (key) {
      case "w":
      case "ArrowUp":
        if (mapsService.isValidMovementTile(playerMovement("north")[0], playerMovement("north")[1], allNpcs))
          player.setYCoordinate(playerMovement("north")[1]);

        player.setPlayerDirection("north");
        break;
      case "s":
      case "arrowdown":
        if (mapsService.isValidMovementTile(playerMovement("south")[0], playerMovement("south")[1], allNpcs))
          player.setYCoordinate(playerMovement("south")[1]);
        player.setPlayerDirection("south");
        break;
      case "a":
      case "arrowleft":
        if (mapsService.isValidMovementTile(playerMovement("west")[0], playerMovement("west")[1], allNpcs))
          player.setXCoordinate(playerMovement("west")[0]);
        player.setPlayerDirection("west");
        break;
      case "d":
      case "arrowright":
        if (mapsService.isValidMovementTile(playerMovement("east")[0], playerMovement("east")[1], allNpcs))
          player.setXCoordinate(playerMovement("east")[0]);
        player.setPlayerDirection("east");
        break;
      case "spacebar":
        if (mapsService.isTileDoor(playerMovement(player.getPlayerDirection())))
          System.out.println("DOROROROROROROROROROR");
          // interact with ur mum
          break;
      default:
        break;
    }



    return player;
  }
}

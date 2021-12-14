package com.porfolio.portfolio.Player;

import java.util.HashMap;
import java.util.List;

import com.porfolio.portfolio.Maps.MapsEntity;
import com.porfolio.portfolio.Maps.MapsRepository;
import com.porfolio.portfolio.Maps.MapsService;
import com.porfolio.portfolio.Maps.Door.DoorService;
import com.porfolio.portfolio.NPC.NPCEntity;
import com.porfolio.portfolio.NPC.NPCService;

import org.springframework.stereotype.Component;

@Component
public class PlayerService {
  PlayerRepository playerRepository;
  MapsRepository mapsRepository;
  MapsService mapsService;
  NPCService npcService;
  DoorService doorService;

  PlayerService(PlayerRepository playerRepository, MapsRepository mapsRepository, MapsService mapsService,
      NPCService npcService,
      DoorService doorService) {
    this.playerRepository = playerRepository;
    this.mapsRepository = mapsRepository;
    this.mapsService = mapsService;
    this.npcService = npcService;
    this.doorService = doorService;
  }

  public Integer[] playerMovement(String playerDirection, PlayerEntity player) {
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

  private void setPlayerMapId(PlayerEntity player) {
    Integer x = playerMovement(player.getPlayerDirection(), player)[0];
    Integer y = playerMovement(player.getPlayerDirection(), player)[1];

    Integer newX = doorService.getDoorLocation(x, y, player.getMap().getMapId()).getNewPlayerXCoordinate() * 20;
    Integer newY = doorService.getDoorLocation(x, y, player.getMap().getMapId()).getNewPlayerYCoordinate() * 20;
    Integer newMapId = doorService.getDoorLocation(x, y, player.getMap().getMapId()).getNewPlayerMapId();
    MapsEntity newMap = mapsRepository.findById(newMapId).get();

    player.setXCoordinate(newX);
    player.setYCoordinate(newY);
    player.setMap(newMap);
  }

  public PlayerEntity movePlayer(String key) {
    PlayerEntity player = playerRepository.findById(0).get();

    List<NPCEntity> allNpcs = npcService.getNPCPositions();

    Integer mapId = player.getMap().getMapId();

    switch (key) {
      case "w":
      case "ArrowUp":
        if (mapsService.isValidMovementTile(playerMovement("north", player)[0], playerMovement("north", player)[1],
            allNpcs, mapId))
          player.setYCoordinate(playerMovement("north", player)[1]);

        player.setPlayerDirection("north");
        break;
      case "s":
      case "ArrowDown":
        if (mapsService.isValidMovementTile(playerMovement("south", player)[0], playerMovement("south", player)[1],
            allNpcs, mapId))
          player.setYCoordinate(playerMovement("south", player)[1]);
        player.setPlayerDirection("south");
        break;
      case "a":
      case "ArrowLeft":
        if (mapsService.isValidMovementTile(playerMovement("west", player)[0], playerMovement("west", player)[1],
            allNpcs, mapId))
          player.setXCoordinate(playerMovement("west", player)[0]);
        player.setPlayerDirection("west");
        break;
      case "d":
      case "ArrowRight":
        if (mapsService.isValidMovementTile(playerMovement("east", player)[0], playerMovement("east", player)[1],
            allNpcs, mapId))
          player.setXCoordinate(playerMovement("east", player)[0]);
        player.setPlayerDirection("east");
        break;
      case "-":
        player.setHealth(player.getHealth() - 10);
        break;
      case "+":
        player.setHealth(player.getHealth() + 10);
        break;
      case "spacebar":
        if (mapsService.isTileDoor(playerMovement(player.getPlayerDirection(), player), player.getMap().getMapId()))
          setPlayerMapId(player);
        // interact with ur mum
        // get id of door
        // get id of map that door goes to
        // ????
        // profit
        break;
      default:
        break;
    }

    return player;
  }
}

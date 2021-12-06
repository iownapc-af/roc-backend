package com.porfolio.portfolio.Player;

import com.porfolio.portfolio.Maps.MapsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
  PlayerRepository playerRepository;

  @Autowired
  MapsService mapsService;

  PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  public PlayerEntity movePlayer(String key) {
    PlayerEntity player = playerRepository.getById(0);

    Integer playerXCoord = player.getXCoordinate();
    Integer playerYCoord = player.getYCoordinate();
    Integer playerUpCoord = playerYCoord - 20;
    Integer playerDownCoord = playerYCoord + 20;
    Integer playerLeftCoord = playerXCoord - 20;
    Integer playerRightCoord = playerXCoord + 20;

    // switch (key) {
    //   case "w":
    //   case "ArrowUp":
    //     if (mapsService.isValidMovementTile(playerXCoord, playerUpCoord))
    //       player.setYCoordinate(playerUpCoord);

    //     player.setPlayerDirection("north");
    //     break;
    //   case "s":
    //   case "arrowdown":
    //     if (mapsService.isValidMovementTile(playerXCoord, playerDownCoord))
    //       player.setYCoordinate(playerDownCoord);
    //     player.setPlayerDirection("south");
    //     break;
    //   case "a":
    //   case "arrowleft":
    //     if (mapsService.isValidMovementTile(playerLeftCoord, playerYCoord))
    //       player.setXCoordinate(playerLeftCoord);
    //     player.setPlayerDirection("east");
    //     break;
    //   case "d":
    //   case "arrowright":
    //     if (mapsService.isValidMovementTile(playerRightCoord, playerYCoord))
    //       player.setXCoordinate(playerRightCoord);
    //     player.setPlayerDirection("west");
    //     break;
    //   default:
    //     break;
    // }

    return player;
  }
}

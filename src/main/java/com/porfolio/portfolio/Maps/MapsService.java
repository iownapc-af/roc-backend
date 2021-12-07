package com.porfolio.portfolio.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.porfolio.portfolio.NPC.NPCEntity;
import com.porfolio.portfolio.Player.PlayerEntity;

import org.springframework.stereotype.Component;

@Component
public class MapsService {
  MapsRepository mapsRepository;
  String mapString;

  MapsService(MapsRepository mapsRepository) {
    this.mapsRepository = mapsRepository;
    this.mapString = mapsRepository.getById(0).getMapContents();
  }

  public List<String> getMapContents(Integer id) {
    ArrayList<String> mapRows = new ArrayList<>(Arrays.asList(mapString.split("\\|")));

    return mapRows;
  }

  private boolean isTileEmpty(Integer x, Integer y) {
    String[] map = mapString.split("\\|");

    if (map[y / 20].charAt(x / 20) == ' ')
      return true;

    return false;
  }

  private boolean isTileNotOccupied(Integer x, Integer y, List<NPCEntity> allNpcs, PlayerEntity player) {
    List<NPCEntity> filteredNpcs = allNpcs.stream().filter((npc) -> {
      return npc.getXCoordinate().equals(x) && npc.getYCoordinate().equals(y);
    }).collect(Collectors.toList());

    final Integer playerX = player.getXCoordinate();
    final Integer playerY = player.getYCoordinate();

    if (filteredNpcs.size() == 0 && (playerX != x && playerY != y))
      return true;

    return false;
  }

  public boolean isValidMovementTile(Integer x, Integer y, List<NPCEntity> allNpcs, PlayerEntity player) {
    if (isTileNotOccupied(x, y, allNpcs, player) && isTileEmpty(x, y)) {
      return true;
    }

    return false;
  }

  private boolean isTileNotOccupied(Integer x, Integer y, List<NPCEntity> allNpcs) {
    List<NPCEntity> filteredNpcs = allNpcs.stream().filter((npc) -> {
      return npc.getXCoordinate().equals(x) && npc.getYCoordinate().equals(y);
    }).collect(Collectors.toList());

    if (filteredNpcs.size() == 0)
      return true;

    return false;
  }

  public boolean isValidMovementTile(Integer x, Integer y, List<NPCEntity> allNpcs) {
    if (isTileNotOccupied(x, y, allNpcs) && isTileEmpty(x, y)) {
      return true;
    }

    return false;
  }

  public boolean isTileDoor(Integer[] movement) {
    String[] map = mapString.split("\\|");

    if (map[movement[1] / 20].charAt(movement[0] / 20) == ':')
      return true;

    return false;
  }
}

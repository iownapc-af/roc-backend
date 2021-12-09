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

  MapsService(MapsRepository mapsRepository) {
    this.mapsRepository = mapsRepository;
  }

  public ArrayList<String> getMapContents(Integer id) {
    ArrayList<String> mapRows = new ArrayList<>(
        Arrays.asList(mapsRepository.getById(id).getMapContents().split("\\|")));

    return mapRows;
  }

  private boolean isTileEmpty(Integer x, Integer y, Integer mapId) {
    ArrayList<String> map = getMapContents(mapId);

    if (map.get(y / 20).charAt(x / 20) == ' ')
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

  public boolean isValidMovementTile(Integer x, Integer y, List<NPCEntity> allNpcs, PlayerEntity player,
      Integer mapId) {
    if (isTileNotOccupied(x, y, allNpcs, player) && isTileEmpty(x, y, mapId)) {
      return true;
    }

    return false;
  }

  private boolean isTileNotOccupied(Integer x, Integer y, List<NPCEntity> allNpcs, Integer mapId) {
    List<NPCEntity> filteredNpcs = allNpcs.stream().filter((npc) -> {
      if (npc.getMap().getMapId() == mapId) {
        return npc.getXCoordinate().equals(x) && npc.getYCoordinate().equals(y);
      }
      return false;
    }).collect(Collectors.toList());

    if (filteredNpcs.size() == 0)
      return true;

    return false;
  }

  public boolean isValidMovementTile(Integer x, Integer y, List<NPCEntity> allNpcs, Integer mapId) {
    if (isTileEmpty(x, y, mapId)) {
      if (isTileNotOccupied(x, y, allNpcs, mapId)) {
        return true;
        // do encounter
      }
    }

    return false;
  }

  public boolean isTileDoor(Integer[] coord, Integer mapId) {
    ArrayList<String> map = getMapContents(mapId);

    if (map.get(coord[1] / 20).charAt(coord[0] / 20) == ':')
      return true;

    return false;
  }
}

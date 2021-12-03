package com.porfolio.portfolio.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
  
  public boolean isValidMovementTile(Integer x, Integer y) {
    y /= 20;
    x /= 20;
    
    String[] map = mapString.split("\\|");
    
    System.out.println(map[x]);

    if (map[x].indexOf(y) == ' ') return true;

    return false;
  }
}

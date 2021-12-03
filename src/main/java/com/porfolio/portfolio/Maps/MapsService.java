package com.porfolio.portfolio.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MapsService {
  MapsRepository mapsRepository;

  MapsService(MapsRepository mapsRepository) {
    this.mapsRepository = mapsRepository;
  }

  public List<String> getMapContents(Integer id) {
    String mapString = mapsRepository.getById(id).getMapContents();
    ArrayList<String> mapRows = new ArrayList<>(Arrays.asList(mapString.split("|")));

    System.out.println(mapRows);

    return mapRows;
  }
}

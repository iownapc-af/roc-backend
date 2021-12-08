package com.porfolio.portfolio.Maps.Door;

import org.springframework.stereotype.Component;

@Component
public class DoorService {
  DoorRepository doorRepository;

  public DoorService(DoorRepository doorRepository) {
    this.doorRepository = doorRepository;
  }

  public DoorEntity getDoorLocation(Integer x, Integer y, Integer doorMapId) {
    return doorRepository.findByDoorXCoordinateAndDoorYCoordinateAndDoorMapId(x / 20, y / 20, doorMapId);
  }
}

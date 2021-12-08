package com.porfolio.portfolio.Maps.Door;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoorRepository  extends JpaRepository<DoorEntity, Integer> {
  DoorEntity findByDoorXCoordinateAndDoorYCoordinateAndDoorMapId(Integer doorX, Integer doorY, Integer doorMap);
}

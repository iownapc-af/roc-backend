package com.porfolio.portfolio.Maps.Door;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "doors")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonDeserialize(builder = DoorEntity.DoorEntityBuilder.class)
public class DoorEntity {
  @Id
  private Integer id;

  @Column(name = "door_x_coordinate")
  private Integer doorXCoordinate;

  @Column(name = "door_y_coordinate")
  private Integer doorYCoordinate;

  @Column(name = "door_map_id")
  private Integer doorMapId;

  @Column(name = "new_player_x_coordinate")
  private Integer newPlayerXCoordinate;

  @Column(name = "new_player_y_coordinate")
  private Integer newPlayerYCoordinate;

  @Column(name = "new_player_map_id")
  private Integer newPlayerMapId;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class DoorEntityBuilder {}
}

package com.porfolio.portfolio.Player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Player")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerEntity {
  @Id
  private Integer id;
  
  @Column(name = "player_name")
  private String playerName;

  @Column(name = "player_direction")
  private String playerDirection;
  
  @Column(name = "x_coordinate")
  private Integer xCoordinate;

  @Column(name = "y_coordinate")
  private Integer yCoordinate;

  // inventory
  // equipment
  // quests
}

package com.porfolio.portfolio.Player;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.porfolio.portfolio.Maps.MapsEntity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@JsonDeserialize(builder = PlayerEntity.PlayerEntityBuilder.class)
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

  @ManyToOne
  @Fetch(value=FetchMode.SELECT)
  @JsonIgnore
  @JoinColumn(name="map_id", nullable = false)
  public MapsEntity map;

  // inventory
  // equipment
  // quests
  @JsonPOJOBuilder(withPrefix = "")
  public static final class PlayerEntityBuilder {}
}

package com.porfolio.portfolio.NPC;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.porfolio.portfolio.Maps.MapsEntity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "npc")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NPCEntity {
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  private String type;

  @Column(name = "x_coordinate")
  private Integer xCoordinate;
  
  @Column(name = "y_coordinate")
  private Integer yCoordinate;
  
  @ManyToOne
  @Fetch(value=FetchMode.SELECT)
  @JoinColumn(name="map_id", nullable = false)
  public MapsEntity map;
}
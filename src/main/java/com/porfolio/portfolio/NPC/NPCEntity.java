package com.porfolio.portfolio.NPC;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "NPC")
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
}
package com.porfolio.portfolio.NPC;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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

  private Integer xCoordinate;
  
  private Integer yCoordinate;
}
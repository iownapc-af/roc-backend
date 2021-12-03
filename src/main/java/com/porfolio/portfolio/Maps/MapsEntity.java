package com.porfolio.portfolio.Maps;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class MapsEntity {
  @Id
  private Integer id;

  @Column(name = "map_name")
  private String mapName;

  @Column(name = "map_contents")
  private String mapContents;
}

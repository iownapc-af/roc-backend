package com.porfolio.portfolio.Maps;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.porfolio.portfolio.NPC.NPCEntity;
import com.porfolio.portfolio.Player.PlayerEntity;

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
  @Column(name = "map_id")
  @Id
  private Integer mapId;

  @Column(name = "map_name")
  private String mapName;

  @Column(name = "map_contents")
  private String mapContents;

  @JsonIgnore
  @OneToMany(mappedBy = "map")
  private Set<NPCEntity> npcs;

  @JsonIgnore
  @OneToMany(mappedBy = "map")
  private Set<PlayerEntity> player;
}

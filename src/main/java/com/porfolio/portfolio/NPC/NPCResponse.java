package com.porfolio.portfolio.NPC;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = NPCResponse.NPCResponseBuilder.class)
public class NPCResponse {
  List<NPCEntity> npcs;
  
  @JsonPOJOBuilder(withPrefix = "")
  public static final class NPCResponseBuilder {}
}

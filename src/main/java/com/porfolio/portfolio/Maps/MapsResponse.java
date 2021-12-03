package com.porfolio.portfolio.Maps;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = MapsResponse.MapsResponseBuilder.class)
public class MapsResponse {
  List<String> map;

  @JsonPOJOBuilder(withPrefix = "")
  public static final class MapsResponseBuilder {}
}
